package com.springapp.mvc.services;

import com.springapp.mvc.domain.Usuario;
import com.springapp.mvc.repositories.contracts.BaseRepository;
import com.springapp.mvc.repositories.contracts.UsuarioRepository;
import com.springapp.mvc.services.contracts.BaseService;
import com.springapp.mvc.services.contracts.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by laerteguedes on 04/07/16.
 */
@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario> implements UsuarioService{
}
