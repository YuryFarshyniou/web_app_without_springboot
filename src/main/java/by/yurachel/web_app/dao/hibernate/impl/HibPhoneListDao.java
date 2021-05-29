package by.yurachel.web_app.dao.hibernate.impl;

import by.yurachel.web_app.dao.IDao;
import by.yurachel.web_app.dao.hibernate.SessionFactoryCreator;
import by.yurachel.web_app.entity.Phone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class HibPhoneListDao implements IDao<Phone> {
    private static final Logger LOGGER = LogManager.getLogger(HibPhoneListDao.class);
    private static final SessionFactory sessionFactory =
            SessionFactoryCreator.getSessionFactory();

    @Override
    public List<Phone> findAll() {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Phone");
        List<Phone> list = query.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public Phone findById(long id) {
        throw new UnsupportedOperationException("Unsupported operation.");
    }

    @Override
    public boolean remove(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Phone phone = session.load(Phone.class, id);
            session.delete(phone);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            LOGGER.error("Remove operation wasn't success: {}", e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(String name, Phone object) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("from Phone where name=:name");
            query.setParameter("name", name);

            Phone phone = (Phone) query.uniqueResult();
            phone.setImg(object.getImg());
            phone.setProcessor(object.getProcessor());
            phone.setName(object.getName());
            phone.setPrice(object.getPrice());

            session.update(phone);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            LOGGER.error("Update operation wasn't success {}", e.getMessage());
        }
        return false;
    }

    @Override
    public boolean create(Phone object) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        try {
            session.save(object);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            LOGGER.error(("Create operation wasn't success {}"), e.getMessage());
        }
        return false;
    }

    @Override
    public Phone findByName(String phoneName) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Phone where name=:name");
        query.setParameter("name", phoneName);
        Phone phone = (Phone) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return phone;
    }
}
