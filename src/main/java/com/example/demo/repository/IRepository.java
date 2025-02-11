package com.example.demo.repository;

import java.util.List;

public interface IRepository<T , ID> {
    T save (T entity);
    T findById (ID id);
    List<T> findByAll();
    T update (ID id , T entity);
    void delete (ID id);
}
