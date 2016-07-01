package com.springapp.mvc.domain;

import javax.persistence.*;

/**
 * Created by laerteguedes on 14/06/16.
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Entidade{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String email;

    private String senha;

    private String horaDoShow;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getHoraDoShow() {
        return horaDoShow;
    }

    public void setHoraDoShow(String horaDoShow) {
        this.horaDoShow = horaDoShow;
    }
}
