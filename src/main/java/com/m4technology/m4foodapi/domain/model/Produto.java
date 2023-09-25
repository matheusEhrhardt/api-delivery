package com.m4technology.m4foodapi.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private BigDecimal preco;

    private Boolean ativo;

    @OneToMany
    private List<FotoProduto> fotoProdutos;

    @OneToMany
    private List<ItemPedido> itensPedidos;
}
