package by.yurachel.web_app.service;

import by.yurachel.web_app.entity.Phone;

import java.util.List;

public interface IService<T> {
    List<T> findAll();

    T findById(long id);

    boolean removeById(long id);

    boolean updateById(long id, T object);

    boolean create(T object);

    Phone findByName(String objectName);

}
