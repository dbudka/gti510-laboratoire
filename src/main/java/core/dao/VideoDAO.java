package core.dao;

import core.entity.VideoEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class VideoDAO extends AbstractDAO<VideoEntity> {

    @Resource
    private SessionFactory sessionFactoryShows;

    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactoryShows;
    }

    @Override
    public Class<VideoEntity> getEntityClass() {
        return VideoEntity.class;
    }

    public List<VideoEntity> getVideosByQuery(String params)
    {
        Session session = getSessionFactory().openSession();
        List<VideoEntity> list =  session.createQuery("from " + getEntityClass().getName() + " where name like '%"+params+"%'").list();
        session.close();
        return list;
    }
}
