package core.dao;

import core.entity.HistoryEntity;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

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

}
