<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>hifun-chat</title>
  </head>
   
  <body>
    Welcome to hifun-chat<br/>
    <input type="text" id="showName"/><input id="text" type="text" />
    <button onclick="send()">发送</button>    <button onclick="closeWebSocket()">关闭</button>
    <div id="message">
    </div>
  </body>
   
  <script type="text/javascript">
  	window.onload = function(){
  		var showName = randomName();
  		document.getElementById('showName').value = showName;
  	};
  	
  	var adjWordArr = ['生动的', '好吃的', '野生的', '高端的', '旋转的'];
  	var nWordArr = ['无赖', '企鹅', '工厂', '犀牛', '白纸'];
  	
  	function randomName(){
  		return adjWordArr[parseInt(Math.random()*adjWordArr.length)]
  			+ nWordArr[parseInt(Math.random()*nWordArr.length)];
  	}
  
      var websocket = null;
       
      //判断当前浏览器是否支持WebSocket
      if('WebSocket' in window){
          websocket = new WebSocket("ws://hifun.me:8080/websocket");
//           websocket = new WebSocket("ws://localhost:8080/hifunmaven/websocket");
      }
      else{
          alert('Not support websocket')
      }
       
      //连接发生错误的回调方法
      websocket.onerror = function(){
          setMessageInnerHTML("error<br/>");
      };
       
      //连接成功建立的回调方法
      websocket.onopen = function(event){
          setMessageInnerHTML("open<br/>");
      }
       
      //接收到消息的回调方法
      websocket.onmessage = function(event){
          setMessageInnerHTML(event.data);
      }
       
      //连接关闭的回调方法
      websocket.onclose = function(){
          setMessageInnerHTML("close<br/>");
      }
       
      //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
      window.onbeforeunload = function(){
          websocket.close();
      }
       
      //将消息显示在网页上
      function setMessageInnerHTML(innerHTML){
          document.getElementById('message').innerHTML += innerHTML;
      }
       
      //关闭连接
      function closeWebSocket(){
          websocket.close();
      }
       
      //发送消息
      function send(){
          var message = document.getElementById('text').value;
          if(message == null || message === '' || message.trim() === ''){
        	  alert('message unvalidate.');
        	  return false;
          }
          var showName = document.getElementById('showName').value;
          if(showName == null || showName === '' || showName.trim() === ''){
        	  alert('showName unvalidate.');
        	  return false;
          }
          websocket.send(showName + ";;;" + message);
          document.getElementById('text').value = '';
      }
  </script>
</html>