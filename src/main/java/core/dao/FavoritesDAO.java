package core.dao;

import core.entity.FavoritesEntity;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class FavoritesDAO extends AbstractDAO<FavoritesEntity> {

    @Resource
    private SessionFactory sessionFactoryShows;

    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactoryShows;
    }

    @Override
    public Class<FavoritesEntity> getEntityClass() {
        return FavoritesEntity.class;
    }

}
