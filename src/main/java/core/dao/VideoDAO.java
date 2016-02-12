package core.dao;

import core.entity.VideoEntity;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

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

}
