package com.hifun.servlet;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.log4j.Logger;

import com.hifun.base.session.SessionUser;
import com.hifun.service.IWebSocketService;
import com.hifun.util.ConstantUtil;
import com.hifun.util.DateUtil;
import com.hifun.util.GetHttpSessionConfigurator;
import com.hifun.util.HtmlUtil;
import com.hifun.util.PropertiesUtil;
import com.hifun.util.SpringContextUtil;

import redis.clients.jedis.Jedis;

//该注解用来指定一个URI，客户端可以通过这个URI来连接到WebSocket。类似Servlet的注解mapping。无需在web.xml中配置。
@ServerEndpoint(value = "/hilettersocket", configurator = GetHttpSessionConfigurator.class)
public class HiletterSocket {

    private Logger log = Logger.getLogger(HiletterSocket.class);

    // 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    // concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    private static CopyOnWriteArraySet<HiletterSocket> webSocketSet = new CopyOnWriteArraySet<HiletterSocket>();

    // 与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    private HttpSession httpSession;

    private IWebSocketService webSocketService;

    /**
     * 连接建立成功调用的方法
     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        this.session = session;
        this.httpSession = (HttpSession) config.getUserProperties()
            .get(HttpSession.class.getName());
        webSocketSet.add(this); // 加入set中
        addOnlineCount(); // 在线数加1
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
        log.info("有新连接加入！当前在线人数为" + getOnlineCount());
        initWebSocketService();

        Jedis jedis = new Jedis(PropertiesUtil.returnParam("redis.host"),
            ConstantUtil.REDIS_PORT);
        jedis.auth(PropertiesUtil.returnParam("redis.pass"));
        if (jedis.isConnected()) {
            String message = jedis.get(ConstantUtil.CONS_HILETTER);
            log.info("message--->" + message);
            jedis.close();
            if (message == null) {
                return;
            }
            try {
                sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    // 初始化service对象
    private void initWebSocketService() {
        webSocketService = (IWebSocketService) SpringContextUtil
            .getApplicationContext().getBean("webSocketService");
        if (webSocketService == null) {
            throw new RuntimeException("webSocketService is null, link failed");
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this); // 从set中删除
        subOnlineCount(); // 在线数减1
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
        log.info("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */
    @OnMessage
    public void onMessage(String mes, Session session) {
        String showName = getShowName();
        String message = mes;
        // 生成message的html，然后拼接到redis对象中
        message = generateMesHtml(showName, message);
        System.out.println("来自" + showName + "的消息:" + message);
        log.info("来自" + showName + "的消息:" + message);

        Jedis jedis = new Jedis(PropertiesUtil.returnParam("redis.host"),
            ConstantUtil.REDIS_PORT);
        jedis.auth(PropertiesUtil.returnParam("redis.pass"));
        if (jedis.isConnected()) {
            jedis.append(ConstantUtil.CONS_HILETTER, message);
            jedis.close();
        }

        sendMessageLoop(message);
    }

    /**
     * 获取当前session的用户昵称，为空则返回默认字符串
     * @return 
     * @create: 2016年9月3日 下午10:42:51 yuexia
     * @history:
     */
    private String getShowName() {
        Object udk = httpSession.getAttribute(ConstantUtil.USER_DETAIL_KEY);
        if (udk != null) {
            return ((SessionUser) udk).getNickname()
                    + "(<a href='#' class='hi-letter-user user-title' onclick='userinfo(this, \""
                    + ((SessionUser) udk).getUsername() + "\")'>"
                    + ((SessionUser) udk).getUsername() + "</a>)";
        }
        return ConstantUtil.DEFAULT_NICKNAME;
    }

    /**
     * 组装message为html形式
     * @param showName  用户昵称
     * @param message   消息内容
     * @return 
     * @create: 2016年9月3日 下午10:48:23 yuexia
     * @history:
     */
    private String generateMesHtml(String showName, String message) {
        return "<label style='color:blue;' class='user-title'>" + showName
                + "&nbsp;&nbsp;&nbsp;"
                + DateUtil.getNowTimeString(ConstantUtil.DEFAULT_DATE_FORMAT)
                + "</label><br/>" + "<label style='color:#3C3C3C;'>"
                + HtmlUtil.insertBrLoop(message, 42) + "</label><br/>";
    }

    /**
     * websocket循环发送消息
     * @param message 
     * @create: 2016年9月3日 下午10:51:10 yuexia
     * @history:
     */
    private void sendMessageLoop(String message) {
        if (webSocketSet.isEmpty()) {
            return;
        }
        // 群发消息
        for (HiletterSocket item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    /**
     * 发生错误时调用
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
        log.info("发生错误");
    }

    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
        // this.session.getAsyncRemote().sendText(message);
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        HiletterSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        HiletterSocket.onlineCount--;
    }
}
