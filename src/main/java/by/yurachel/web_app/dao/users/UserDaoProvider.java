package by.yurachel.web_app.dao.users;

import by.yurachel.web_app.dao.IDao;
import by.yurachel.web_app.dao.phones.PhoneDaoProvider;
import by.yurachel.web_app.model.phone.impl.Phone;
import by.yurachel.web_app.model.user.impl.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class UserDaoProvider {
    private static final Logger LOGGER = LogManager.getLogger(PhoneDaoProvider.class);

    private final IDao<User> daoUserProvider;

    public UserDaoProvider(IDao<User> daoUserProvider) {
        this.daoUserProvider = daoUserProvider;
    }

    public IDao<User> getDaoUserProvider() {
        return daoUserProvider;
    }
}
