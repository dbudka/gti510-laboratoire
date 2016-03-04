package core.dao;

import core.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.mapping.List;
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

    public UserEntity getUserEntityByEmail(String email){

        Session session = getSessionFactory().openSession();
        java.util.List<UserEntity> list =  session.createQuery("from " + getEntityClass().getName() + " where email like '"+email+"'").list();
        session.close();
        return (list != null && list.size() > 0) ? list.get(0) : null;
    }

}
