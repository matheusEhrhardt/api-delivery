package com.m4technology.m4foodapi.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.m4technology.m4foodapi.domain.generic.GenericModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Endereco extends GenericModel {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numero;
    private Integer cep;
    private String cidade;
    private String estado;
    private String logadouro;
}
