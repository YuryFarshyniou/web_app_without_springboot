package by.yurachel.web_app.dao.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Component;



public class SessionFactoryContainer {

    private static final Logger LOGGER = LogManager.getLogger(SessionFactoryContainer.class);
    private SessionFactory sessionFactory;

    private SessionFactoryContainer() {

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            LOGGER.info("SessionFactory was successful created. ");
        } catch (Exception e) {
            throw new Error("Error in sessionFactory creating. ", e);
        }
    }


    public static SessionFactory getSessionFactory() {
        return SessionFactoryHolder.instance.sessionFactory;
    }

    private static class SessionFactoryHolder {
        static SessionFactoryContainer instance = new SessionFactoryContainer();
    }

}
