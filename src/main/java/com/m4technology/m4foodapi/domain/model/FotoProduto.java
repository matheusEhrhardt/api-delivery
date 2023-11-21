package com.m4technology.m4foodapi.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.m4technology.m4foodapi.domain.generic.GenericModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class FotoProduto extends GenericModel {
    private String nome;
    private String descricao;
    private String tipo;
    private Long tamanho;
}
