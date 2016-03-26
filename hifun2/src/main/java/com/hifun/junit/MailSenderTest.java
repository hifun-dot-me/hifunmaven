package com.hifun.junit;

import org.junit.Test;

import com.hifun.util.mail.MailSenderInfo;
import com.hifun.util.mail.SimpleMailSender;

public class MailSenderTest {

    @Test
    public void sendMail() {
        String[] tos;
        String[] ccs;
        MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setMailServerPort("25");
        mailInfo.setUserName("1321967761@qq.com");
        mailInfo.setPassword("");
        mailInfo.setFromAddress("1321967761@qq.com");
        mailInfo.setValidate(true);
        mailInfo.setSubject("my subject");
        tos = new String[] { "1321967761@qq.com" };
        ccs = new String[] { "1321967761@qq.com" };
        mailInfo.setContent("<table><tr><td>123</td></tr></table>");
        mailInfo.setTos(tos);
        mailInfo.setCcs(ccs);
        // SendMailThread sendMailThread = new SendMailThread(mailInfo);
        // new Thread(sendMailThread).start();
        SimpleMailSender.sendMail(mailInfo);
    }

}
