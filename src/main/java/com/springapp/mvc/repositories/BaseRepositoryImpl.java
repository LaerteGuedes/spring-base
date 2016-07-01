package com.springapp.mvc.repositories;

import com.springapp.mvc.domain.Entidade;
import com.springapp.mvc.repositories.contracts.BaseRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by laerteguedes on 14/06/16.
 */
@Transactional
public abstract class BaseRepositoryImpl<T extends Entidade> implements BaseRepository<T> {

    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> clazz;

    public BaseRepositoryImpl() {
        Type t = getClass().getGenericSuperclass();
    }

    protected final Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public T save(T s) {
        getCurrentSession().persist(s);
        return s;
    }

    @Override
    public T findOne(Long id) {
        System.out.println(id);
        System.out.println("Class: "+clazz);
        return (T) getCurrentSession().get(clazz,id);
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
