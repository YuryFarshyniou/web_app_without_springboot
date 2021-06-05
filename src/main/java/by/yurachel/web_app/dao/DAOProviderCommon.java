package by.yurachel.web_app.dao;

import by.yurachel.web_app.dao.hibernate.impl.HibPhoneListDao;
import by.yurachel.web_app.dao.jdbc.impl.JDBCPhoneListDAO;
import by.yurachel.web_app.dao.jpa.impl.JPAPhoneListDAO;
import by.yurachel.web_app.entity.Phone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;


public final class DAOProviderCommon {

    private static IDao<Phone> IPhoneDAO;
    private static DAOType type;
    private static final Logger LOGGER = LogManager.getLogger(DAOProviderCommon.class);

    public static void init(String db) {
        type = DAOType.valueOf(db.toUpperCase(Locale.ROOT));
        switch (type) {
            case JPA:
                IPhoneDAO = new JPAPhoneListDAO();
                LOGGER.info("JPA dao was initialized.");
                break;
            case JDBC:
                IPhoneDAO = new JDBCPhoneListDAO();
                LOGGER.info("JDBC dao was initialized.");
                break;
            case HIBERNATE:
                IPhoneDAO = new HibPhoneListDao();
                LOGGER.info("Hibernate dao was initialized.");
                break;
            default:
                LOGGER.info("Initialized was with error.");
        }
    }

    public static class DAOProviderHolder {
        public static final DAOProviderCommon INSTANCE = new DAOProviderCommon();
    }


    private DAOProviderCommon() {

    }

    public static DAOProviderCommon getInstance() {
        return DAOProviderHolder.INSTANCE;
    }

    public IDao<Phone> getIPhoneDAO() {
        return IPhoneDAO;
    }

}
