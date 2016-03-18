package core.dao;

import core.entity.FavoritesEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


import javax.annotation.Resource;
import java.util.List;

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

    public List<FavoritesEntity> findByUserId(int userId){
        Session session = getSessionFactory().openSession();
        List<FavoritesEntity> list =  session.createQuery("from FavoritesEntity favorites where favorites.user.id = " + userId
                + " order by favorites.dateAdded desc").list();
        session.close();

        return list;
    }

    public FavoritesEntity findByVideoId(int videoId){
        Session session = getSessionFactory().openSession();
        List<FavoritesEntity> list =  session.createQuery("from FavoritesEntity favorites where favorites.video.id = " + videoId).list();
        session.close();
        FavoritesEntity entity = list.get(0);
        return entity;
    }
}
