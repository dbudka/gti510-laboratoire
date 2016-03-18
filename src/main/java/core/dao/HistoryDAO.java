package core.dao;

import core.entity.HistoryEntity;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import java.util.*;
import org.hibernate.Session;

import javax.annotation.Resource;

@Repository
public class HistoryDAO extends AbstractDAO<HistoryEntity> {

    @Resource
    private SessionFactory sessionFactoryShows;

    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactoryShows;
    }

    @Override
    public Class<HistoryEntity> getEntityClass() {
        return HistoryEntity.class;
    }

    public List<HistoryEntity> findByUserId(int userId){
        Session session = getSessionFactory().openSession();
        List<HistoryEntity> list =  session.createQuery("from HistoryEntity history where history.user.id = " + userId
                + " order by history.dateViewed desc").list();
        session.close();
        return list;
    }
}
