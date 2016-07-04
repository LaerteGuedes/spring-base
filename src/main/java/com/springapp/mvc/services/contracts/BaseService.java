package com.springapp.mvc.services.contracts;

import com.springapp.mvc.domain.Entidade;

import java.util.List;

/**
 * Created by laerteguedes on 04/07/16.
 */
public interface BaseService<T extends Entidade> {

    T save (T t);

    T findOne(Long id);

    List<T> findAll();

    long count();

    boolean exists(Long id);

    void delete(Long id);

    void delete(T t);

}
