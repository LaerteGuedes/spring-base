package com.springapp.mvc.repositories;

import com.springapp.mvc.domain.Entidade;
import com.springapp.mvc.repositories.contracts.BaseRepository;

/**
 * Created by laerteguedes on 14/06/16.
 */
public class BaseRepositoryImpl<T extends Entidade> implements BaseRepository<T> {

    @Override
    public T save(T s) {
        return null;
    }

    @Override
    public T findOne(Long id) {
        return null;
    }

    @Override
    public boolean exists(Long id) {
        return false;
    }

    @Override
    public Iterable<T> findAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(T t) {

    }
}
