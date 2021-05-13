package by.yurachel.web_app.dao;

import by.yurachel.web_app.dao.impl.PhoneListDAO;
import by.yurachel.web_app.entity.Phone;


public final class DAOProvider {

    private AbstractDAO<Phone> abstractPhoneDAO = new PhoneListDAO();

    public static class DAOProviderHolder {
        public static final DAOProvider INSTANCE = new DAOProvider();
    }

    private DAOProvider() {}

    public static DAOProvider getInstance() {
                return DAOProviderHolder.INSTANCE;
    }

    public AbstractDAO<Phone> getAbstractDAO() {
        return abstractPhoneDAO;
    }

    public void setAbstractDAO(AbstractDAO<Phone> abstractDAO) {
        this.abstractPhoneDAO = abstractDAO;
    }
}
