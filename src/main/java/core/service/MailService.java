package core.service;

import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


@Service
public class MailService {

    public static String EMAIL_SENDER = "dbudka1992@gmail.com";
    public static String PASSWORD_SENDER = "ak338901992";
    public static String ALIAS_SENDER = "MarcoVision";

    public boolean sendMail(final String emailToReceive, final String subject, final String messageText){


        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(EMAIL_SENDER, PASSWORD_SENDER);
                    }
                });
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL_SENDER));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(emailToReceive));
            message.setSubject(subject);
            message.setText(messageText);

            Transport.send(message);
            return true;
        } catch (Exception exp) {

            exp.printStackTrace();

            return false;
        }
    }
}
