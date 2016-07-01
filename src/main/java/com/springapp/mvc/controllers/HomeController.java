package com.springapp.mvc.controllers;

import com.springapp.mvc.domain.Usuario;
import com.springapp.mvc.repositories.contracts.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * Created by laerteguedes on 27/06/16.
 */
@Controller
@RestController
@RequestMapping(value = "/home")
public class HomeController {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity test(){
        Usuario u = usuarioRepository.findOne(1L);
        System.out.println(u.getNome());

        return new ResponseEntity(Arrays.asList(u), HttpStatus.OK);
    }

}
