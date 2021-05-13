package by.yurachel.web_app.dao;

import java.util.List;

public abstract class AbstractDAO<T> {
    public abstract List<T> findAll();

    public abstract T findEntityById(long id);

    public abstract boolean remove(long id);

    public abstract boolean updateByName(String name,T object);

    public abstract boolean addEntity(T object);


}
