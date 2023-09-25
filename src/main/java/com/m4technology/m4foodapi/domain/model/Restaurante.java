package com.m4technology.m4foodapi.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.m4technology.m4foodapi.domain.enums.LogicoEnum;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Restaurante {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @Column(name = "en_ativo")
    private LogicoEnum ativo;

    @Column(name = "en_aberto")
    private LogicoEnum aberto;

    @PositiveOrZero
    @Column(name = "taxa_frete")
    private Double taxaFrete;

    @Column(name = "data_cadastro")
    private Date dataCadastro;

    @JsonIgnore
    @CreationTimestamp
    @Column(name = "data_atualizacao")
    private Date dataAtualizacao;

    @Valid
    @NotNull
    @ManyToOne
    @JoinColumn(name = "cozinha_id")
    private Cozinha cozinhaId;

    @Valid
    @NotNull
    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco enderecoId;

    @Valid
    @NotNull
    @ManyToMany
    @JoinTable(name = "restaurante_forma_pagamento",
            joinColumns = @JoinColumn(name = "restaurante_id"),
            inverseJoinColumns = @JoinColumn(name = "forma_pagamento_id"))
    private List<FormaPagamento> formasPagamento;
}
