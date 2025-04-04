package com.sakila.rest.services;

import java.util.List;

public interface IService <T, K>{
    T create(T obj);
    T read(K id);
    T update(T obj);
    boolean delete(K id);
    List<T> readAll();
}
