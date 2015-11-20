package dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Zim on 19.11.2015.
 */
public interface GenericDao <T extends Serializable>{
    public void create(T object);

    public T getByPK(int key);

    public void update(T object);

    void delete(int id);

    public List<T> getAll();
}