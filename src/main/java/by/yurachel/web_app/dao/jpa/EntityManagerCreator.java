package by.yurachel.web_app.dao.jpa;

import by.yurachel.web_app.dao.hibernate.SessionFactoryCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerCreator {
    private static final Logger LOGGER = LogManager.getLogger(SessionFactoryCreator.class);
    private EntityManager entityManager;

    private EntityManagerCreator() {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("PhoneDB");
        try {
            entityManager = emf.createEntityManager();
        } catch (Exception e) {
            throw new Error("Error in entityManager creating. ", e);
        }
    }

    public static EntityManager getInstance() {
        return EntityManagerHolder.instance.entityManager;
    }

    private static class EntityManagerHolder {
        static EntityManagerCreator instance = new EntityManagerCreator();
    }
}
