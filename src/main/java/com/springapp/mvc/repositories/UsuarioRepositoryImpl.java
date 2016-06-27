package com.springapp.mvc.repositories;

import com.springapp.mvc.domain.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by laerteguedes on 14/06/16.
 */
@Repository
public class UsuarioRepositoryImpl extends BaseRepositoryImpl<Usuario>{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
