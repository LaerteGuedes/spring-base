package com.springapp.mvc.repositories;

import com.springapp.mvc.domain.Entidade;
import com.springapp.mvc.repositories.contracts.BaseRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by laerteguedes on 14/06/16.
 */
@Repository
@Transactional
public abstract class BaseRepositoryImpl<T extends Entidade> implements BaseRepository<T> {

    @Autowired
    private SessionFactory sessionFactory;

    protected Class<? extends T> domainType;

    public BaseRepositoryImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        domainType = (Class) pt.getActualTypeArguments()[0];
    }

    protected Session currentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public T save(T s) {
        return null;
    }

    @Override
    public T findOne(Long id) {
        return (T) currentSession().load(domainType,id);
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
