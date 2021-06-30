package by.yurachel.web_app.dao.users.impl;

import by.yurachel.web_app.dao.IDao;
import by.yurachel.web_app.dao.SessionFactoryContainer;
import by.yurachel.web_app.model.phone.impl.Phone;
import by.yurachel.web_app.model.user.impl.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao implements IDao<User> {
    private static final Logger LOGGER = LogManager.getLogger(UserDao.class);

    private final SessionFactory sessionFactory = SessionFactoryContainer.getSessionFactory();

    @Override
    public List<User> findAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from User");
        query.setCacheable(true);
        List<User> list = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public User findById(long id) {
        return null;
    }

    @Override
    public boolean removeById(long id) {
        return false;
    }

    @Override
    public boolean updateById(long id, User object) {
        return false;
    }

    @Override
    public boolean create(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.save(user);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            LOGGER.error(("Create operation wasn't success {}"), e.getMessage());
        }
        return false;
    }

    @Override
    public User findByName(String userName) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from User where userName=:userName");
        query.setCacheable(true);
        query.setParameter("userName", userName);
        User user = (User) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return user;
    }
}
