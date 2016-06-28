package com.springapp.mvc.repositories;

import com.springapp.mvc.domain.Usuario;
import com.springapp.mvc.repositories.contracts.UsuarioRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by laerteguedes on 14/06/16.
 */
@Repository
@Transactional
public class UsuarioRepositoryImpl extends BaseRepositoryImpl<Usuario> implements UsuarioRepository{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
