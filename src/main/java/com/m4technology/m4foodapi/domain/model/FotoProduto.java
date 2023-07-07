package com.m4technology.m4foodapi.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class FotoProduto {
    @Id
    private Long id;
    private String nome;
    private String descricao;
    private String tipo;
    private Long tamanho;
}
