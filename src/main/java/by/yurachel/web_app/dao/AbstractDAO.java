package by.yurachel.web_app.dao;

import java.util.List;

public abstract class AbstractDAO<T> {
    public abstract List<T> findAll();

    public abstract T findEntityById(int id);

    public abstract boolean remove(T object);

    public abstract boolean remove(int id);

    public abstract boolean update(T object);

    public abstract boolean addEntity(T object);

}
