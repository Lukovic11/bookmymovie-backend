package com.bookmymovie.serviceImpl;

import com.bookmymovie.entity.EmailData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(EmailData emailData){
        SimpleMailMessage  message=new SimpleMailMessage();
        message.setTo(emailData.getToEmail());
        message.setSubject(emailData.getSubject());
        message.setText(emailData.getBody());

        javaMailSender.send(message);
    }
}
