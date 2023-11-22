package com.m4technology.m4foodapi.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantidade;
    @Column(name = "preco_unitario")
    private BigDecimal precoUnitario;
    @Column(name = "preco_total")
    private BigDecimal precoTotal;
    private String observacao;
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedidoId;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produtoId;
}
