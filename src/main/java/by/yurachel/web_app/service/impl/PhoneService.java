package by.yurachel.web_app.service.impl;

import by.yurachel.web_app.dao.DaoProvider;
import by.yurachel.web_app.entity.Phone;
import by.yurachel.web_app.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class PhoneService implements IService<Phone> {

    private DaoProvider provider;

    @Autowired
    public void setProvider(DaoProvider provider) {
        this.provider = provider;
    }

    @Override
    @Transactional
    public List<Phone> findAll() {
        return provider.getIPhoneDAO().findAll();
    }

    @Override
    @Transactional
    public Phone findById(long id) {
        return (Phone) provider.getIPhoneDAO().findById(id);
    }

    @Override
    @Transactional
    public boolean removeById(long id) {
        return provider.getIPhoneDAO().removeById(id);
    }

    @Override
    @Transactional
    public boolean updateById(long id, Phone phone) {
        return provider.getIPhoneDAO().updateById(id, phone);
    }

    @Override
    @Transactional
    public boolean create(Phone phone) {
        return provider.getIPhoneDAO().create(phone);
    }

    @Override
    @Transactional
    public Phone findByName(String phoneName) {
        return provider.getIPhoneDAO().findByName(phoneName);
    }
}
