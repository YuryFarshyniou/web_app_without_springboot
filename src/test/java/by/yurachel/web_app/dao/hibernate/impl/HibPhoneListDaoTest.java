package by.yurachel.web_app.dao.hibernate.impl;

import by.yurachel.web_app.dao.jpa.EntityManagerCreator;
import by.yurachel.web_app.entity.Phone;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.junit.jupiter.api.Assertions.*;

class HibPhoneListDaoTest {
    private static final EntityManager entityManager =
            EntityManagerCreator.getInstance();

    @Test
    void create() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Phone phone = new Phone("Gopa", 567, "Cool", "img");
        entityManager.persist(phone);
        transaction.commit();
    }
}