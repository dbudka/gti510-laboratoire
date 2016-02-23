package core.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private DozerBeanMapper mapper;

    @Autowired
    private MailService mailService;

    public boolean sendEmail(final Integer userID) {

        String link = "www.google.com";
        String email = "d.budka@hotmail.com";
        String subject = "Pas";
        String message = "This is your email for the reinitialisation : " + link;
        return mailService.sendMail(email, subject, message);
    }

}
