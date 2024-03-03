package es.codeurjc.Instapick.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;



@Service
public class EmailServiceImpl implements IEmailService{

    @Value("${spring.mail.username}")
    private String emailUser;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(String toUser, String subject, String message) {

         MimeMessage mMessage = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mMessage,true);

            helper.setFrom(emailUser);
            helper.setTo(toUser);
            helper.setSubject("Account created successfully");
            helper.setText(message);
            mailSender.send(mMessage);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
