package by.yurachel.web_app.dao;

import by.yurachel.web_app.entity.Phone;

import java.util.List;

public abstract class AbstractDAO<T> {
    public abstract List<T> findAll();

    public abstract T findEntity(long id);

    public abstract boolean remove(long id);

    public abstract boolean update(String name, T object);

    public abstract boolean addEntity(T object);

    public abstract Phone findEntity(String objectName);


}
