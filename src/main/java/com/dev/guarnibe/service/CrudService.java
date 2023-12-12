package com.dev.guarnibe.service;

import java.util.List;

public interface CrudService<T> {
    void save(T data);
    boolean delete(T data);
    List<T> getAll();
    T getById(Long id);
}
