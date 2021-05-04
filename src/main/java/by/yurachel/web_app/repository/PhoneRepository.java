package by.yurachel.web_app.repository;

import by.yurachel.web_app.entity.Phone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PhoneRepository {
    private static final PhoneRepository INSTANCE = new PhoneRepository();
    private final List<Phone> phones = new ArrayList<>();
    public static final List<Integer> ID = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));


    public static PhoneRepository getInstance() {
        return INSTANCE;
    }

    private PhoneRepository() {
        phones.add(new Phone(1, "Xiaomi Mi 11 lite", 500, "Snapdragon 732G"));
        phones.add(new Phone(2, "Xiaomi Mi 11 ultra", 1200, "Snapdragon 888"));
        phones.add(new Phone(3, "Iphone 12 mini", 1000, "Apple A14 Bionic"));
        phones.add(new Phone(4, "Samsung Galaxy S20", 900, "Exynos 990"));
        phones.add(new Phone(5, "Poco X3 Pro", 350, "Snapdragon 860"));
    }

    public List<Phone> getPhones() {
        return this.phones;
    }

    public void addProduct(Phone phone) {
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

    public void removePhone(int id) {
       boolean isRemove =  phones.removeIf(phone -> phone.getId() == id);
       if(!isRemove){
           throw new IllegalArgumentException("The phone wasn't found");
       }

    }

    public Phone findPhoneById(int id) {
        Phone findPhone = new Phone();
        for (Phone phone : phones) {
            if (phone.getId() == id) {
                findPhone = phone;
                break;
            }
        }
        return findPhone;
    }


    public int findPhoneIDByName(String name) {
        Integer findIdPhone = null;
        for (Phone phone : phones) {
            if (phone.getName().equals(name)) {
                findIdPhone = phone.getId();
                break;
            }
        }
        if (findIdPhone == null) {
            throw new NullPointerException("Such phone wasn't found");
        }
        return findIdPhone;
    }

    public static int maxPhoneID() {
        return Collections.max(ID);
    }

    public static void removeId(int id) {
        ID.removeIf(id2 -> id2 == id);
    }


}
