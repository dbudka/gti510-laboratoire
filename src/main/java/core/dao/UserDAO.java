package core.dao;

import core.entity.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UserDAO extends AbstractDAO<UserEntity> {

    @Resource
    private SessionFactory sessionFactoryShows;

    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactoryShows;
    }

    @Override
    public Class<UserEntity> getEntityClass() {
        return UserEntity.class;
    }

}
