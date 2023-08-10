package com.m4technology.m4foodapi.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Endereco {
    @Id
    private Long id;
    private Integer numero;
    private Integer cep;
    private String cidade;
    private String estado;
    private String logadouro;
}
