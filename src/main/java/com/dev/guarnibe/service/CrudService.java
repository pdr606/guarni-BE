package com.dev.guarnibe.service;

import java.util.List;

public interface CrudService<T> {
    default void save(T data) {
    }

    default boolean delete(T data) {
        return false;
    }

    default List<T> getAll() {
        return null;
    }

    default T getById(Long id) {
        return null;
    }

    default void save(List<T> dtosList ){

    }
}
