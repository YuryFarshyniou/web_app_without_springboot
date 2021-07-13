package by.yurachel.web_app.service.impl;

import by.yurachel.web_app.dao.phones.PhoneDaoProvider;
import by.yurachel.web_app.model.phone.impl.Phone;
import by.yurachel.web_app.service.IService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PhoneService implements IService<Phone> {

    private static final Logger LOGGER = LogManager.getLogger(PhoneService.class);

    private PhoneDaoProvider provider;

    @Autowired
    public void setProvider(PhoneDaoProvider provider) {
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
