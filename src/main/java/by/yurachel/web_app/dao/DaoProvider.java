package by.yurachel.web_app.dao;

import by.yurachel.web_app.dao.hibernate.impl.HibPhoneDao;
import by.yurachel.web_app.dao.jdbc.impl.JdbcPhoneDao;
import by.yurachel.web_app.dao.jpa.impl.JpaPhoneDao;
import by.yurachel.web_app.entity.Phone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;


public final class DaoProvider {

    private static IDao<Phone> IPhoneDAO;
    private static DaoType type;
    private static final Logger LOGGER = LogManager.getLogger(DaoProvider.class);

    public static void init(String db) {
        type = DaoType.valueOf(db.toUpperCase(Locale.ROOT));

        switch (type) {
            case JPA:
                IPhoneDAO = new JpaPhoneDao();
                LOGGER.info("JPA dao was initialized.");
                break;
            case JDBC:
                IPhoneDAO = new JdbcPhoneDao();
                LOGGER.info("JDBC dao was initialized.");
                break;
            case HIBERNATE:
                IPhoneDAO = new HibPhoneDao();
                LOGGER.info("Hibernate dao was initialized.");
                break;
            default:
                LOGGER.info("Initialized was with error.");
        }
    }

    public static class DAOProviderHolder {


        public static final DaoProvider INSTANCE = new DaoProvider();
    }


    private DaoProvider() {

    }

    public static DaoProvider getInstance() {
        return DAOProviderHolder.INSTANCE;
    }

    public IDao<Phone> getIPhoneDAO() {
        return IPhoneDAO;
    }

}
