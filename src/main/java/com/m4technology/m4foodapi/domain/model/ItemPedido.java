package com.m4technology.m4foodapi.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.m4technology.m4foodapi.domain.generic.GenericModel;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
public class ItemPedido extends GenericModel {

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
