package com.m4technology.m4foodapi.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.m4technology.m4foodapi.domain.generic.GenericModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
public class Cozinha extends GenericModel {

    @NotBlank
    private String nome;

    @JsonIgnore
    @CreationTimestamp
    @Column(name = "dt_atualizacao")
    private LocalDateTime dataAtualizacao;
}
