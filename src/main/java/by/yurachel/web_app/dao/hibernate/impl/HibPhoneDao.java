package by.yurachel.web_app.dao.hibernate.impl;

import by.yurachel.web_app.dao.IDao;
import by.yurachel.web_app.dao.hibernate.SessionFactoryContainer;
import by.yurachel.web_app.entity.Phone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class HibPhoneDao implements IDao<Phone> {
    private static final Logger LOGGER = LogManager.getLogger(HibPhoneDao.class);
    private static final SessionFactory sessionFactory =
            SessionFactoryContainer.getSessionFactory();

    @Override
    public List<Phone> findAll() {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Phone");
        query.setCacheable(true);
        List<Phone> list = query.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public Phone findById(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Phone where id=:id");
        query.setCacheable(true);
        query.setParameter("id", id);
        Phone phone = (Phone) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return phone;
    }

    @Override
    public boolean removeById(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Phone phone = session.get(Phone.class, id);
        if (phone == null) {
            return false;
        }
        session.delete(phone);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean updateById(long id, Phone object) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from Phone where id=:id");
        query.setParameter("id", id);
        query.setCacheable(true);
        Phone phone = (Phone) query.uniqueResult();
        if (phone != null) {
            phone.setImg(object.getImg());
            phone.setProcessor(object.getProcessor());
            phone.setName(object.getName());
            phone.setPrice(object.getPrice());

            session.update(phone);
            session.getTransaction().commit();
            session.close();
            return true;
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
        query.setCacheable(true);
        query.setParameter("name", phoneName);
        Phone phone = (Phone) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return phone;
    }
}
