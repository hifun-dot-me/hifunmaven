package com.hifun.util.mail;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

/**  
* 简单邮件（不带附件的邮件）发送器  
*/   
public class SimpleMailSender  {   
/**  
  * 以文本格式发送邮件  
  * @param mailInfo 待发送的邮件的信息  
  */   
    public boolean sendTextMail(MailSenderInfo mailInfo) {   
      // 判断是否需要身份认证   
      MyAuthenticator authenticator = null;   
      Properties pro = mailInfo.getProperties();  
      if (mailInfo.isValidate()) {   
      // 如果需要身份认证，则创建一个密码验证器   
        authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());   
      }  
      // 根据邮件会话属性和密码验证器构造一个发送邮件的session   
      Session sendMailSession = Session.getInstance(pro,authenticator);   
      try {   
      // 根据session创建一个邮件消息   
      Message mailMessage = new MimeMessage(sendMailSession);   
      // 创建邮件发送者地址   
      Address from = new InternetAddress(mailInfo.getFromAddress());   
      // 设置邮件消息的发送者   
      mailMessage.setFrom(from);   
      // 创建邮件的接收者地址，并设置到邮件消息中   
      Address to = new InternetAddress(mailInfo.getToAddress());   
      mailMessage.setRecipient(Message.RecipientType.TO,to);   
      // 设置邮件消息的主题   
      mailMessage.setSubject(mailInfo.getSubject());   
      // 设置邮件消息发送的时间   
      mailMessage.setSentDate(new Date());   
      // 设置邮件消息的主要内容   
      String mailContent = mailInfo.getContent();   
      mailMessage.setText(mailContent);   
      // 发送邮件   
      Transport.send(mailMessage);  
      return true;   
      } catch (MessagingException ex) {   
          ex.printStackTrace();   
      }   
      return false;   
    }   
      
    /**  
      * 以HTML格式发送邮件  
      * @param mailInfo 待发送的邮件信息  
      */   
    public static boolean sendHtmlMail(MailSenderInfo mailInfo){   
      // 判断是否需要身份认证   
      MyAuthenticator authenticator = null;  
      Properties pro = mailInfo.getProperties();  
      //如果需要身份认证，则创建一个密码验证器    
      if (mailInfo.isValidate()) {   
        authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());  
      }   
      // 根据邮件会话属性和密码验证器构造一个发送邮件的session   
      Session sendMailSession = Session.getInstance(pro,authenticator);   
      try {   
      // 根据session创建一个邮件消息   
      Message mailMessage = new MimeMessage(sendMailSession);   
      // 创建邮件发送者地址   
      Address from = new InternetAddress(mailInfo.getFromAddress());   
      // 设置邮件消息的发送者   
      mailMessage.setFrom(from);   
      // 创建邮件的接收者地址，并设置到邮件消息中   
      Address to = new InternetAddress(mailInfo.getToAddress());   
      // Message.RecipientType.TO属性表示接收者的类型为TO   
      mailMessage.setRecipient(Message.RecipientType.TO,to);   
      // 设置邮件消息的主题   
      mailMessage.setSubject(mailInfo.getSubject());   
      // 设置邮件消息发送的时间   
      mailMessage.setSentDate(new Date());   
      // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象   
      Multipart mainPart = new MimeMultipart();   
      // 创建一个包含HTML内容的MimeBodyPart   
      BodyPart html = new MimeBodyPart();   
      // 设置HTML内容   
      html.setContent(mailInfo.getContent(), "text/html; charset=utf-8");   
      mainPart.addBodyPart(html);   
      // 将MiniMultipart对象设置为邮件内容   
      mailMessage.setContent(mainPart);   
      // 发送邮件   
      Transport.send(mailMessage);   
      return true;   
      } catch (MessagingException ex) {   
          ex.printStackTrace();
      }   
      return false;   
    }   
    /**
     * 带附件邮件发送方法
     */
    @SuppressWarnings("static-access")
	public static boolean sendMail(MailSenderInfo mailInfo) {
    	Properties props = mailInfo.getProperties();
    	MyAuthenticator authenticator = null;
    	if(mailInfo.isValidate()){
    		authenticator = new MyAuthenticator(mailInfo.getUserName(),mailInfo.getPassword()); 
    	}
    	Session session = Session.getInstance(props,authenticator);
    	
    	try {
    		MimeMessage mimeMsg = new MimeMessage(session);
    		javax.mail.Transport transport = session.getTransport("smtp"); 
    		Address from = new InternetAddress(mailInfo.getFromAddress());
    		mimeMsg.setFrom(from);
    		String[] sendtos = mailInfo.getTos();
    		InternetAddress[] tos = new InternetAddress[sendtos.length];
    		
    		for(int i=0;i<sendtos.length;i++){
    			tos[i] = new InternetAddress(sendtos[i]);
    		}
    		mimeMsg.setRecipients(javax.mail.internet.MimeMessage.RecipientType.TO, tos);
    		String[] cs = mailInfo.getCcs();
    		if(cs.length>0){
    			InternetAddress[] ccs = new InternetAddress[cs.length];
        		for(int i = 0;i<cs.length;i++){
        			ccs[i] = new InternetAddress(cs[i]);
        		}
        		mimeMsg.setRecipients(MimeMessage.RecipientType.CC, ccs);
    		}
    		mimeMsg.setSubject(mailInfo.getSubject(), "utf-8");
    		MimeBodyPart messageBodyPart1 = new MimeBodyPart();
    		messageBodyPart1.setContent(mailInfo.getContent(), "text/html;charset=utf-8");
    		Multipart multipart = new MimeMultipart();//附件传输格式 
    	    multipart.addBodyPart(messageBodyPart1); 
    	    String[] fileNames = mailInfo.getAttachFileNames();
    	    if(fileNames!=null&&fileNames.length>0){
    	    	for (int i = 0; i < fileNames.length; i++) { 
        	        MimeBodyPart messageBodyPart2 = new MimeBodyPart(); 
        	        //选择出每一个附件名 
        	        String filename = fileNames[i].split(",")[0]; 
        	        System.out.println("附件名：" + filename); 
        	        String displayname = fileNames[i].split(",")[1]; 
        	        //得到数据源 
        	        FileDataSource fds = new FileDataSource(filename); 
        	        //得到附件本身并至入BodyPart 
        	        messageBodyPart2.setDataHandler(new DataHandler(fds)); 
        	        //得到文件名同样至入BodyPart 
        	        messageBodyPart2.setFileName(MimeUtility.encodeText(displayname)); 
        	        multipart.addBodyPart(messageBodyPart2); 
        	      }
    	    }
    	    mimeMsg.setContent(multipart); 
    	    //设置信件头的发送日期 
    	    mimeMsg.setSentDate(new Date()); 
    	    
    	    mimeMsg.saveChanges(); 
    	    //发送邮件 
    	    transport.send(mimeMsg); 
    	    transport.close();
    	    return true;
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	return false;
	}
}
