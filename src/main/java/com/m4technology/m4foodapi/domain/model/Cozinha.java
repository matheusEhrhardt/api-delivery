package com.m4technology.m4foodapi.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Cozinha {
    @Id
    private Long id;
    private String nome;
}
