package es.codeurjc.Instapick.service;

public interface IEmailService {
    void sendEmail(String toUser, String subject, String message); // (Declaration) Send mail to user e-mail
}
