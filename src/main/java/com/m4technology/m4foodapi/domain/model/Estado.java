package com.m4technology.m4foodapi.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Estado {
    @Id
    private Long id;
    private String nome;
    @OneToMany
    private List<Cidade> cidades;
}
