package org.example.service;

import java.util.List;

public interface Service<T> {

    void save(T t);

    void deleteById(int id);

    T update(int id, T t);

    List<T> getAll();

    T findById(int id);

}
