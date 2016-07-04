package com.springapp.mvc.services;

import com.springapp.mvc.domain.Entidade;
import com.springapp.mvc.repositories.contracts.BaseRepository;
import com.springapp.mvc.services.contracts.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by laerteguedes on 04/07/16.
 */
public class BaseServiceImpl<T extends Entidade> implements BaseService<T>{

    @Autowired
    private BaseRepository<T> repo;

    @Override
    @Transactional
    public T save(T t) {
        if (t.getId() != null){
            return repo.update(t);
        }
        return repo.insert(t);
    }

    @Override
    @Transactional
    public T findOne(Long id) {
        return repo.findOne(id);
    }

    @Override
    @Transactional
    public List<T> findAll() {
        return repo.findAll();
    }

    @Override
    @Transactional
    public long count() {
        return repo.count();
    }

    @Override
    @Transactional
    public boolean exists(Long id) {
        return repo.exists(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repo.delete(id);
    }

    @Override
    @Transactional
    public void delete(T t) {
        repo.delete(t);
    }
}
