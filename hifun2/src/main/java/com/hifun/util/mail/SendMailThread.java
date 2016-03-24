package com.hifun.util.mail;


import java.util.List;

/**
 * 启用线程发邮件
 * @author admin
 *
 */
public class SendMailThread implements Runnable {
	private MailSenderInfo mailInfo;//单邮件
	private List<MailSenderInfo> mailInfoList;//多邮件集合
	
	
	public SendMailThread(){
		
	}
	public SendMailThread(MailSenderInfo mailInfo) {
		this.mailInfo = mailInfo;
	}
	public SendMailThread(List<MailSenderInfo> mailInfoList){
		this.mailInfoList = mailInfoList;
	}
	
	@Override
	public void run() {
		if(mailInfo != null){
			SimpleMailSender.sendMail(mailInfo);
		}
		if(mailInfoList!=null && mailInfoList.size()>0){
			for(MailSenderInfo mailSenderInfo : mailInfoList){
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				SimpleMailSender.sendMail(mailSenderInfo);
			}
		}
	}

}
