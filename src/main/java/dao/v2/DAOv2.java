package dao.v2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtil;

import java.util.List;

public abstract class DAOv2<T> {

    protected SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public abstract boolean create(T obj);

    public abstract boolean delete(T obj);

    public abstract boolean update(T obj);

    public abstract T find(int id);

    public abstract List<T> list();

    protected Session getSession() {
        return sessionFactory.openSession();
    }
}
