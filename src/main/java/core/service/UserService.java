package core.service;

import api.dto.UserDTO;
import core.dao.UserDAO;
import core.entity.UserEntity;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private DozerBeanMapper mapper;

    @Autowired
    private MailService mailService;

    @Autowired
    private UserDAO UserDAO;

    public UserDTO findById(final Integer id) {

        UserEntity entity = UserDAO.findById(id);

        return mapper.map(entity, UserDTO.class);
    }

    public UserDTO createOrUpdateUser(final UserDTO user) {

        user.setPasswordChanging(false);
        UserEntity entity = UserDAO.save(mapper.map(user, UserEntity.class));

        if(entity != null) {

            user.setId(entity.getId());

            sendEmailForConfirmation(user);
            return user;
        }

        return null;
    }


    public boolean sendEmailForConfirmation(final UserDTO userDTO) {

        String email = userDTO.getEmail();
        String subject = "Welcome";
        String message = "Welcome to McDavids Videos " + userDTO.getUser();
        return mailService.sendMail(email, subject, message);
    }

    public boolean sendEmailForPasswordInit(final Integer userID) {

        String link = "www.google.com";
        String email = "d.budka@hotmail.com";
        String subject = "Pas";
        String message = "This is your email for the reinitialisation : " + link;
        return mailService.sendMail(email, subject, message);
    }

}
