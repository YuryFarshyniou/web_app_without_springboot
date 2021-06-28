package by.yurachel.web_app.dao;

import by.yurachel.web_app.model.phone.impl.Phone;

import java.util.List;

public interface IDao<T> {
    List<T> findAll();

    T findById(long id);

    boolean removeById(long id);

    boolean updateById(long id, T object);

    boolean create(T object);

    Phone findByName(String objectName);


}
