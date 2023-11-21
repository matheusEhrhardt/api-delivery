package com.m4technology.m4foodapi.domain.model;

import com.m4technology.m4foodapi.domain.generic.GenericModel;
import lombok.Data;

@Data
public class Cliente extends GenericModel{

    private String nome;

    private String email;

    private String contato;

    private boolean isAtivo;

    public Cliente(String nome, String email, String contato) {
        this.nome = nome;
        this.email = email;
        this.contato = contato;
    }

    public void ativar(){
        this.isAtivo = true;
    }
}
