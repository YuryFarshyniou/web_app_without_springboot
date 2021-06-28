package by.yurachel.web_app.dao;

import by.yurachel.web_app.model.phone.impl.Phone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DaoProvider {
    private static final Logger LOGGER = LogManager.getLogger(DaoProvider.class);


    private IDao<Phone> IPhoneDAO;

    @Autowired
    public DaoProvider(IDao<Phone> IPhoneDAO) {
        this.IPhoneDAO = IPhoneDAO;
    }

    public IDao<Phone> getIPhoneDAO() {
        return IPhoneDAO;
    }

    public void setIPhoneDAO(IDao<Phone> IPhoneDAO) {
        this.IPhoneDAO = IPhoneDAO;
    }

    public static Logger getLOGGER() {
        return LOGGER;
    }
}
