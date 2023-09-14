package com.m4technology.m4foodapi.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
public class Cozinha {
    @Id
    private Long id;
    private String nome;

    @JsonIgnore
    @CreationTimestamp
    @Column(name = "dt_atualizacao")
    private LocalDateTime dataAtualizacao;
}
