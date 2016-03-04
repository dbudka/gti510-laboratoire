package core.service;

import api.dto.UserDTO;
import core.dao.UserDAO;
import core.entity.UserEntity;
import org.dozer.DozerBeanMapper;
import org.hsqldb.rights.User;
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

        if (UserDAO.getUserEntityByEmail(user.getEmail()) == null) {

            user.setPasswordChanging(false);
            UserEntity entity = UserDAO.save(mapper.map(user, UserEntity.class));

            if (entity != null) {

                user.setId(entity.getId());

                sendEmailForConfirmation(user);
                return user;
            }
        }

        return null;
    }


    public UserDTO updateUserPassword(final UserDTO user) {

        UserEntity entity = UserDAO.findById(user.getId());
        entity.setPassword(user.getPassword());

        if (entity != null && entity.getPasswordChanging()) {

            user.setPasswordChanging(false);
            UserDAO.update(mapper.map(user, UserEntity.class));

            mailService.sendMail(user.getEmail(), "Password changed confirmed", "You changed your password.");
            return user;

        }

        return null;
    }

    public UserDTO connectAndGetUser(String email, String password) {

        UserDTO user = mapper.map(UserDAO.getUserEntityByEmail(email), UserDTO.class);

        if (user != null && user.getPassword().equals(password)) {

            return user;
        }

        return null;
    }


    public boolean sendEmailForConfirmation(final UserDTO userDTO) {

        String email = userDTO.getEmail();
        String subject = "Welcome";
        String message = "Welcome to McDavids Videos " + userDTO.getUsername();
        return mailService.sendMail(email, subject, message);
    }

    public boolean resetPassword(final String email, final String link) {

        UserEntity userEntity = UserDAO.getUserEntityByEmail(email);
        if (userEntity != null) {

            userEntity.setPasswordChanging(true);
            UserDAO.update(userEntity);
            return sendEmailForPasswordInit(userEntity, link);
        }

        return false;
    }

    public boolean sendEmailForPasswordInit(UserEntity userEntity, final String link) {

        String linkWithPath = link + "/user/reset/password?" + "id=" + userEntity.getId();
        String subject = "Password change";
        String message = "This is your email for the reinitialisation : " + linkWithPath;
        return mailService.sendMail(userEntity.getEmail(), subject, message);
    }

}
