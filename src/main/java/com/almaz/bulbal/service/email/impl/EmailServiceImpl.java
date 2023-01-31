package com.almaz.bulbal.service.email.impl;

import com.almaz.bulbal.dto.email.EmailDetails;
import com.almaz.bulbal.service.email.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;
    private final SpringTemplateEngine springTemplateEngine;

    public EmailServiceImpl(JavaMailSender javaMailSender, SpringTemplateEngine springTemplateEngine) {
        this.javaMailSender = javaMailSender;
        this.springTemplateEngine = springTemplateEngine;
    }


    @Override
    public String sendSimpleMail(EmailDetails details) {
        try {

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
            Context context = new Context();
            Map<String, Object> model = new HashMap<>();
            model.put("userName", details.getUserName());
            model.put("location", "United States");
            model.put("sign", "Java Developer");
            helper.setFrom("bulbal@gmail.com");
            helper.setTo(details.getEmail());
            helper.setSubject("Registration");
            String html = springTemplateEngine.process("welcome-email", context);
            context.setVariables(model);
            helper.setText(html, true);

            javaMailSender.send(message);
            return "Mail Sent Successfully...";
        } catch (MessagingException e) {
            return "Error while sending mail!!!";
        }
    }
    public int generateDigits() {
        int min = 1000;
        int max = 9999;
        return (int) (Math.random() * (max - min + 1) + min);

    }

}



