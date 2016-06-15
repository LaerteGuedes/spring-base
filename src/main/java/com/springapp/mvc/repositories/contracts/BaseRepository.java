package com.springapp.mvc.repositories.contracts;

import com.springapp.mvc.domain.Entidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by laerteguedes on 14/06/16.
 */
public interface BaseRepository<T extends Entidade>{

    T save(T s);

    T findOne(Long id);

    boolean exists(Long id);

    Iterable<T> findAll();

    long count();

    void delete(Long id);

    void delete(T t);

}
