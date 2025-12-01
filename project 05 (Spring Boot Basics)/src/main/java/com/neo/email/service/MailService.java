package com.neo.email.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailService {
    //成员变量
    @Value("${spring.mail.username}")
    private String from;
    @Autowired
    private JavaMailSender mailSender;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //成员方法
    public void sayHello() {
        System.out.println("Hello World");
    }
    //发送文本邮件
    public void sendSimpleMail (String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        message.setFrom(from);
        mailSender.send(message);
    }
    //发送HTML邮件
    public void sendHtmlMail (String to, String subject, String content) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content,true);
        mailSender.send(message);
    }
    //发送带附件的邮件
    public void sendAttachmentsMail (String to, String subject, String content, String filePath) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content,true);
        FileSystemResource file = new FileSystemResource(new File(filePath));
        String fileName = file.getFilename();
        helper.addAttachment(fileName,file);
        helper.addAttachment(fileName + "_test",file);
        mailSender.send(message);
    }
    //发送带图片的邮件
    public void sendInlineResourceMail (String to, String subject, String content, String rscPath, String rscId) {
        logger.info("发送静态图片邮件开始：{},{},{},{},{}",to,subject,content,rscPath,rscId);
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content,true);
            FileSystemResource res = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId,res);
            helper.addInline(rscId,res);
            mailSender.send(message);
            logger.info("发送静态图片邮件成功！");
        } catch (MessagingException e) {
            logger.error("发送静态图片邮件失败！",e);
        }
    }
}
