package iuh.fit.se.ecommercepc.service;

public interface MailService {
    void sendVerificationEmail(String to, String token);
}
