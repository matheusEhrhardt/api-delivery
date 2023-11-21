package com.m4technology.m4foodapi.domain.model;

import com.m4technology.m4foodapi.domain.generic.GenericModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
@Data
@Entity
public class Usuario extends GenericModel {

    @NotBlank
    private String nome;
    @NotBlank
    private String email;
    @NotBlank
    @Size(min = 6)
    private String senha;

    @Column(name = "data_cadastro")
    private Date dataCadastro;
}
