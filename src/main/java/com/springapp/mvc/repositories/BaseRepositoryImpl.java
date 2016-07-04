package com.springapp.mvc.repositories;

import com.springapp.mvc.domain.Entidade;
import com.springapp.mvc.repositories.contracts.BaseRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

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
        ParameterizedType pt = (ParameterizedType) t;
        this.clazz = (Class) pt.getActualTypeArguments()[0];
    }

    protected final Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public T insert(T s) {
        getCurrentSession().persist(s);
        return s;
    }

    @Override
    public T update(T s) {
        getCurrentSession().merge(s);
        return s;
    }

    @Override
    public T findOne(Long id) {
        return (T) getCurrentSession().get(clazz,id);
    }

    @Override
    public boolean exists(Long id) {
        T t = (T) getCurrentSession().get(clazz, id);
        if (t != null){
            return true;
        }
        return false;
    }

    @Override
    public List<T> findAll() {
        return getCurrentSession().createQuery("from "+clazz.getName()).list();
    }

    @Override
    public long count() {
        List<T> objs = getCurrentSession().createQuery("from "+clazz.getName()).list();
        return objs.size();
    }

    @Override
    public void delete(Long id) {
        T entity = (T) getCurrentSession().get(clazz, id);

        if (entity != null){
            getCurrentSession().delete(entity);
        }
    }

    @Override
    public void delete(T t) {
        getCurrentSession().delete(t);
    }
}
