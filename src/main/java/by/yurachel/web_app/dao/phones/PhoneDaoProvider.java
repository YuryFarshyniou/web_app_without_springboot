package by.yurachel.web_app.dao.phones;

import by.yurachel.web_app.dao.IDao;
import by.yurachel.web_app.model.phone.impl.Phone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;


@Component
public class PhoneDaoProvider {
    private static final Logger LOGGER = LogManager.getLogger(PhoneDaoProvider.class);

    private final IDao<Phone> IPhoneDAO;


    public PhoneDaoProvider(IDao<Phone> IPhoneDAO) {
        this.IPhoneDAO = IPhoneDAO;
    }

    public IDao<Phone> getIPhoneDAO() {
        return IPhoneDAO;
    }

    public static Logger getLOGGER() {
        return LOGGER;
    }
}
