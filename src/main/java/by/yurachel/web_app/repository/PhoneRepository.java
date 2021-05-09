package by.yurachel.web_app.repository;

import by.yurachel.web_app.dao.PhoneListDAO;
import by.yurachel.web_app.entity.Phone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class PhoneRepository {

    private final List<Phone> phones;
    private final List<Long> id;
    public static final Logger ROOT_LOGGER = LogManager.getRootLogger();


    public List<Long> getId() {
        return id;
    }

    public static class PhoneRepositoryHolder {
        public static final PhoneRepository INSTANCE = new PhoneRepository();
    }

    public static PhoneRepository getInstance() {
        return PhoneRepositoryHolder.INSTANCE;
    }

    private PhoneRepository() {
        PhoneListDAO phoneDAO = new PhoneListDAO();
        id = new ArrayList<>(Arrays.asList(1L, 2L, 3L, 4L, 5L));
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
        return phones.stream()
                .filter((phone) -> phone.getId() == id)
                .findFirst()
                .orElse(null);
    }


    public Long findPhoneIDByName(String name) {
        Optional<Phone> phone2 = phones.stream()
                .filter((phone) -> phone.getName().equals(name))
                .findFirst();
        return (phone2.isPresent()) ? phone2.get().getId() : null;
    }

    public long maxPhoneID() {
        return Collections.max(this.id);
    }

    public void addID(long id) {
        this.id.add(id + 1);
    }

    public boolean removeId(long id) {
        return this.id.removeIf(id2 -> id2 == id);
    }
}
