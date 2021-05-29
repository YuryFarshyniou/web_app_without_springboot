package by.yurachel.web_app.dao;

import by.yurachel.web_app.entity.Phone;

import java.util.List;

public interface IDao<T> {
    List<T> findAll();

    T findById(long id);

    boolean remove(long id);

    boolean update(String name, T object);

    boolean create(T object);

    Phone findByName(String objectName);



}
