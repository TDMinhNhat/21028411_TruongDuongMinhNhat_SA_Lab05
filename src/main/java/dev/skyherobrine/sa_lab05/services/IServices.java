package dev.skyherobrine.sa_lab05.services;

import java.util.List;
import java.util.Optional;

public interface IServices<T, ID>{
    boolean save(T entity);
    boolean update(T entity);
    boolean delete(T t);
    Optional<T> findOne(ID id);
    List<T> findAll();
}
