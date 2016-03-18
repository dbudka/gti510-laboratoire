package core.service;

import api.dto.UserDTO;
import core.dao.UserDAO;
import core.entity.UserEntity;
import org.dozer.DozerBeanMapper;
import org.hsqldb.rights.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
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
            user.setConnectTry(0);
            user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
            UserEntity entity = UserDAO.save(mapper.map(user, UserEntity.class));

            if (entity != null) {

                user.setId(entity.getId());

                sendEmailForConfirmation(user);
                return user;
            }
        }

        if(user.getId()!=null) {
            UserDAO.update(mapper.map(user, UserEntity.class));
            return user;
        }

        return null;
    }

    public UserDTO addConnectTry(final UserDTO user, Integer valueToadd) {
        UserEntity userEntity = UserDAO.getUserEntityByEmail(user.getEmail());
        userEntity.setConnectTry(userEntity.getConnectTry()+valueToadd);
        UserDAO.update(userEntity);
        return user;
    }

    public Integer getConnectTry(final UserDTO user) {
        UserEntity userEntity = UserDAO.getUserEntityByEmail(user.getEmail());
        return userEntity.getConnectTry();
    }


    public UserDTO resetConnectTry(final UserDTO user) {
        UserEntity userEntity = UserDAO.getUserEntityByEmail(user.getEmail());
        userEntity.setConnectTry(0);
        UserDAO.update(userEntity);
        return user;
    }

    public UserDTO updateUserPassword(final UserDTO user) {

        UserEntity entity = UserDAO.findById(user.getId());

        if (entity != null && entity.getPasswordChanging()) {

            entity.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
            entity.setPasswordChanging(false);
            entity.setConnectTry(0);
            UserDAO.update(entity);

            mailService.sendMail(entity.getEmail(), "Password changed confirmed", "You changed your password.");
            return user;

        }

        return null;
    }

    public UserDTO connectAndGetUser(String email, String password) {

        UserDTO user = mapper.map(UserDAO.getUserEntityByEmail(email), UserDTO.class);


        if (user != null && BCrypt.checkpw(password, user.getPassword())) {

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

        System.out.println(email);
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
        String message = "This is your email for the reinitialisation : " + linkWithPath+"";
        return mailService.sendMail(userEntity.getEmail(), subject, message);
    }

}
