package com.m4technology.m4foodapi.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Restaurante {
    @Id
    private Long id;
    private String nome;
    private Boolean ativo;
    private Boolean aberto;
    private Date dataCadastro;
    private Date dataAtualizacao;
}
