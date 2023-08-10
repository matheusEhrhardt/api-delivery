package com.m4technology.m4foodapi.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
public class Produto {
    @Id
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
