package com.security.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

//    public void sendResetLink(String toEmail, String token) {
//        String resetUrl = "http://localhost:8080/reset-password?token=" + token;
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(toEmail);
//        message.setSubject("Password Reset Request");
//        message.setText("Click this link to reset your password: " + resetUrl);
//        mailSender.send(message);
//    }
public void sendOtp(String toEmail, String otp) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(toEmail);
    message.setSubject("Your Password Reset OTP");
    message.setText("Your OTP for password reset is: " + otp + "\nIt will expire in 5 minutes.");
    mailSender.send(message);
}
}

