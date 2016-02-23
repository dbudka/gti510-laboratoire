package core.service;

import api.dto.UserDTO;
import core.dao.UserDAO;
import core.entity.UserEntity;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private DozerBeanMapper mapper;

    @Autowired
    private UserDAO UserDAO;

    public UserDTO findById(final Integer id) {

        UserEntity entity = UserDAO.findById(id);

        return mapper.map(entity, UserDTO.class);
    }

    public void createUser(final UserDTO User) {

        UserEntity entity = UserDAO.save(mapper.map(User, UserEntity.class));
    }
}
