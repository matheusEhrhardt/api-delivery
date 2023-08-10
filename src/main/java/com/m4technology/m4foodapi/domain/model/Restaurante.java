package com.m4technology.m4foodapi.domain.model;

import com.m4technology.m4foodapi.domain.enums.LogicoEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Restaurante {
    @Id
    private Long id;

    private String nome;

    @Column(name = "en_ativo")
    private LogicoEnum ativo;

    @Column(name = "en_aberto")
    private LogicoEnum aberto;

    @Column(name = "taxa_frete")
    private Double taxaFrete;

    @Column(name = "data_cadastro")
    private Date dataCadastro;

    @Column(name = "data_atualizacao")
    private Date dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "cozinha_id")
    private Cozinha cozinhaId;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco enderecoId;

    @ManyToMany
    @JoinTable(name = "restaurante_forma_pagamento",
            joinColumns = @JoinColumn(name = "restaurante_id"),
            inverseJoinColumns = @JoinColumn(name = "forma_pagamento_id"))
    private List<FormaPagamento> formasPagamento;
}
