package ua.training.model.dao;

import ua.training.model.entity.Coffee;

import java.util.List;


public interface GenericDao<T> extends AutoCloseable {
    void create(T entity);
    T findById(int id);
    List<T> findAll();
    void update(T entity);
    void delete(int id);
}