package com.neo.email.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import javax.annotation.Resource;
import javax.mail.MessagingException;

@SpringBootTest
public class ServiceTest {
    @Resource
    MailService mailService;
    @Resource
    TemplateEngine templateEngine;

    @Test
    public void sayHelloTest() {
        mailService.sayHello();
    }
    @Test
    //发送文本邮件
    public void sendSimpleMailTest() {
        mailService.sendSimpleMail("a13222326075@126.com","这是第一封邮件","大家好，这是我的第一封邮件");
    }
    @Test
    //发送HTML邮件
    public void sendHtmlMailTest() throws MessagingException {
        String content ="<html>\n" +
                            "<body>\n" +
                                "<h3> hello world,这是一封HTML邮件</h3>\n" +
                            "</body>\n" +
                        "</html>";
        mailService.sendHtmlMail("a13222326075@126.com","这是一封HTML邮件",content);
    }
    @Test
    //发送带附件的邮件
    public void sendAttachmentsMailTest() throws MessagingException {
        String filePath = "C:\\colasa\\Java project\\project 05 (Spring Boot Basics)\\attachments\\我是附件.txt";
        mailService.sendAttachmentsMail("a13222326075@126.com","这是一封带附件的邮件","这是一封带附件邮件的内容",filePath);
    }
    @Test
    //发送带图片的邮件
    public void sendInlineResourceMailTest() {
        String imgPath="C:\\colasa\\Java project\\project 05 (Spring Boot Basics)\\pictures\\1.jpg";
        String rscId="neo001";
        String content = "<html>" +
                            "<body> 这是一封带图片的邮件 <img src\'cid:" + rscId + "\'></img>" +
                                                     "<img src\'cid:" + rscId + "\'></img>" +
                            "</body>" +
                        "</html>";
        mailService.sendInlineResourceMail("a13222326075@126.com","这是一封带图片的文件",content,imgPath,rscId);
    }
    @Test
    //发送模版邮件
    public void sendTemplateMailTest() throws MessagingException {
        Context context = new Context();
        context.setVariable("id","006");
        String emailContent = templateEngine.process("emailTemplate",context);
        mailService.sendHtmlMail("a13222326075@126.com","这是一封模版邮件",emailContent);
    }
}
