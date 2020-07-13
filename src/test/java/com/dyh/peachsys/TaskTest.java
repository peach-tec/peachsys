package com.dyh.peachsys;

import com.dyh.peachsys.spring_task.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/7/12-21:35
 * @address 成都
 */
@SpringBootTest
public class TaskTest {
    /**
     * 邮箱发送
     */
    @Autowired
    private JavaMailSender mailSender;

    @Test
    public void mailTest() {
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件主题
        message.setSubject("测试邮件发送...");
        //邮件内容
        message.setText("你好：测试邮件，无需回复");
        //发送到
        message.setTo("*****@qq.com");
        //发送人
        message.setFrom("*****@qq.com");
        //发送
        mailSender.send(message);
    }

    @Test
    public void mailTest2() throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        //第二个参数表示支持文件发送
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        //邮件主题
        helper.setSubject("测试邮件");
        //邮件内容,第二个参数表示支持html标签
        helper.setText("<h1>无需回复此邮件....</h1>", true);
        //添加附件
        helper.addAttachment("1.jpg", new File("C:/Users/DYH/Desktop/1.jpg"));
        //发送到
        helper.setTo("623395454@qq.com");
        //发送人
        helper.setFrom("623395454@qq.com");
        //发送
        mailSender.send(message);
    }
}
