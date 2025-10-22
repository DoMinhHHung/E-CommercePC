package iuh.fit.se.ecommercepc.service.impl;

import iuh.fit.se.ecommercepc.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {
    private final JavaMailSender mailSender;

    @Override
    public void sendVerificationEmail(String to, String token) {
        String verifyUrl = "http://localhost:8080/api/auth/verify?token=" + token;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Xác thực tài khoản của bạn");
        message.setText("Bấm vào link này để xác thực tài khoản: " + verifyUrl);
        mailSender.send(message);
    }
}
