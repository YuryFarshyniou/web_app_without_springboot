package by.yurachel.web_app.dao.hibernate;

import by.yurachel.web_app.dao.IDao;
import by.yurachel.web_app.dao.hibernate.impl.HibPhoneListDao;
import by.yurachel.web_app.entity.Phone;

public class DAOProvider {
    private IDao<Phone> IPhoneDAO = new HibPhoneListDao();

    public static class DAOProviderHolder {
        public static final DAOProvider INSTANCE = new DAOProvider();
    }

    public static DAOProvider getInstance() {
        return DAOProviderHolder.INSTANCE;
    }

    private DAOProvider() {
    }

    public IDao<Phone> getIPhoneDAO() {
        return IPhoneDAO;
    }

}
