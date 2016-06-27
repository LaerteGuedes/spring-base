package com.springapp.mvc.repositories;

import com.springapp.mvc.domain.Entidade;
import com.springapp.mvc.repositories.contracts.BaseRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by laerteguedes on 14/06/16.
 */
abstract public class BaseRepositoryImpl<T extends Entidade> implements BaseRepository<T> {

    public abstract Session getSession();

    @Override
    public T save(T s) {
        getSession().persist(s);
        return s;
    }

    @Override
    public T findOne(Long id) {
        return (T) getSession().load(Entidade.class,id);
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
