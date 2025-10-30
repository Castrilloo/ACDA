package db.dao;

import java.util.List;

public interface DenericDAO<T,ID> {
    void create(T entity) throws Exception;
    T findById(ID id);
    List<T> findAll();
    void update(T entity) throws Exception;
    void delete(T entity) throws Exception;
}
