package core.dao;

import core.entity.CommentEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class CommentDAO extends AbstractDAO<CommentEntity> {

    @Resource
    private SessionFactory sessionFactoryShows;

    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactoryShows;
    }

    @Override
    public Class<CommentEntity> getEntityClass() {
        return CommentEntity.class;
    }

    public List<CommentEntity> findByVideoId(int videoId){
        Session session = getSessionFactory().openSession();
        List<CommentEntity> list =  session.createQuery("from CommentEntity comment where comment.video.id - " + videoId
                + " order by comment.postDate desc").list();
        session.close();
        return list;
    }

    public List<CommentEntity> findByVideoIdPaginated(int videoId, int page, int limit){
        Session session = getSessionFactory().openSession();
        Query query = session.createQuery("from CommentEntity comment where comment.video.id = " + videoId
                + " order by comment.postDate desc");
        query.setFirstResult(page * limit);
        query.setMaxResults(limit);
        List<CommentEntity> list = query.list();
        session.close();
        return list;
    }
}
