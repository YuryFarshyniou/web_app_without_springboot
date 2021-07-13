package by.yurachel.web_app.service.impl;

import by.yurachel.web_app.dao.users.UserDaoProvider;
import by.yurachel.web_app.model.phone.impl.Phone;
import by.yurachel.web_app.model.user.impl.User;
import by.yurachel.web_app.service.IService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServes implements IService<User> {
    private static final Logger LOGGER = LogManager.getLogger(PhoneService.class);

    private UserDaoProvider provider;

    @Autowired
    public void setProvider(UserDaoProvider provider) {
        this.provider = provider;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return provider.getDaoUserProvider().findAll();
    }

    @Override
    @Transactional
    public User findById(long id) {
        return provider.getDaoUserProvider().findById(id);
    }

    @Override
    @Transactional
    public boolean removeById(long id) {
        return provider.getDaoUserProvider().removeById(id);
    }

    @Override
    @Transactional
    public boolean updateById(long id, User user) {
        return provider.getDaoUserProvider().updateById(id, user);
    }

    @Override
    @Transactional
    public boolean create(User user) {
        return provider.getDaoUserProvider().create(user);
    }

    @Override
    public User findByName(String objectName) {
        return provider.getDaoUserProvider().findByName(objectName);
    }
}
