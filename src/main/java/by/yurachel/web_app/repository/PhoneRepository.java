package by.yurachel.web_app.repository;

import by.yurachel.web_app.dao.PhoneListDAO;
import by.yurachel.web_app.entity.Phone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PhoneRepository {
    private static  PhoneRepository INSTANCE;
    private final List<Phone> phones;
    public static final List<Long> ID = new ArrayList<>(Arrays.asList(1L, 2L, 3L, 4L, 5L));
    public static final Logger ROOT_LOGGER = LogManager.getRootLogger();


    public static PhoneRepository getInstance() {
        if (INSTANCE == null) {
            return INSTANCE = new PhoneRepository();
        }
        return INSTANCE;
    }

    private PhoneRepository() {
        PhoneListDAO phoneDAO = new PhoneListDAO();
        this.phones = phoneDAO.findAll();
    }

    public List<Phone> getPhones() {
        return this.phones;
    }

    public void addPhone(Phone phone) {
        phones.add(phone);
    }

    public void changePhoneParam(Phone newPhone, String oldPhoneName) {
        boolean phoneExists = false;
        int index = 0;
        for (Phone phone : phones) {
            if (phone.getName().equalsIgnoreCase(oldPhoneName)) {
                phoneExists = true;
                index = phones.indexOf(phone);
                break;
            }
        }
        if (phoneExists) {
            phones.set(index, newPhone);
        }
    }

    public void removePhone(long id) {
        phones.removeIf(phone -> phone.getId() == id);
    }

    public Phone findPhoneById(long id) {
        Phone findPhone = new Phone();
        for (Phone phone : phones) {
            if (phone.getId() == id) {
                findPhone = phone;
                break;
            }
        }
        return findPhone;
    }


    public long findPhoneIDByName(String name) {
        Long findIdPhone = null;
        try {
            for (Phone phone : phones) {
                if (phone.getName().equals(name)) {
                    findIdPhone = phone.getId();
                    break;
                }
            }
            if (findIdPhone == null) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            ROOT_LOGGER.error("Phone wasn't found: {} ", name);
        }
        return findIdPhone;
    }

    public static long maxPhoneID() {
        return Collections.max(ID);
    }

    public static void removeId(long id) {
        ID.removeIf(id2 -> id2 == id);
    }


}
