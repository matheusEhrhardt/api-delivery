package com.m4technology.m4foodapi.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;
@Data
@Entity
public class Usuario {

    @Id
    private Long id;

    private String nome;

    private String email;

    private String senha;

    @Column(name = "data_cadastro")
    private Date dataCadastro;
}
