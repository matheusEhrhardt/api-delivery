package com.m4technology.m4foodapi.domain.model;

import com.m4technology.m4foodapi.domain.generic.GenericModel;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Permissao extends GenericModel {

    private String nome;

    private String descricao;
}
