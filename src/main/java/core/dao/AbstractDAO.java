package core.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public abstract class AbstractDAO<T> {

    public T save(T entity){
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Integer id = (Integer)session.save(entity);
        session.getTransaction().commit();
        session.close();

        return findById(id);
    }

    public void delete(T entity){

        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        session.close();
    }

    public void update(T entity){
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    public T findById(int id) {
        Session session = getSessionFactory().openSession();
        T entity = (T) session.get(getEntityClass(), id);
        session.close();
        return entity;

    }

    public List<T> findAll(){

        Session session = getSessionFactory().openSession();
        List<T> list =  session.createQuery("from " + getEntityClass().getName()).list();
        session.close();
        return list;
    }

    public abstract SessionFactory getSessionFactory();
    public abstract Class<T> getEntityClass();
}
