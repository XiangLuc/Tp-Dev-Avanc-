package dao.v2;

import entities.Annonce;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AnnonceDAOv2  extends DAOv2<Annonce> {

    @Override
    public boolean create(Annonce obj) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            session.persist(obj);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Annonce obj) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            session.remove(obj);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Annonce obj) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            session.merge(obj);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Annonce find(int id) {
        try (Session session = getSession()) {
            return session.get(Annonce.class, id);
        }
    }

    @Override
    public List<Annonce> list() {
        try (Session session = getSession()) {
            return session.createQuery("from Annonce", Annonce.class).list();
        }
    }
}