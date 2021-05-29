package by.yurachel.web_app.dao.jdbc;

import by.yurachel.web_app.dao.IDao;
import by.yurachel.web_app.dao.jdbc.impl.JDBCPhoneListDAO;
import by.yurachel.web_app.entity.Phone;


public final class DAOProvider {

    private IDao<Phone> IPhoneDAO = new JDBCPhoneListDAO();

    public static class DAOProviderHolder {
        public static final DAOProvider INSTANCE = new DAOProvider();
    }

    private DAOProvider() {
    }

    public static DAOProvider getInstance() {
        return DAOProviderHolder.INSTANCE;
    }

    public IDao<Phone> getIPhoneDAO() {
        return IPhoneDAO;
    }

}
