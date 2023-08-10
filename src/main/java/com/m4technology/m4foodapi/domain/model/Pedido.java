package com.m4technology.m4foodapi.domain.model;

import com.m4technology.m4foodapi.domain.enums.StatusPedidoEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Pedido {

    @Id
    private Long id;

    private BigDecimal subTotal;

    private BigDecimal taxaFrete;

    private BigDecimal valorTotal;

    private Date dataCriacao;

    private Date dataConfirmacao;

    private Date dataCancelamento;

    private Date dataEntrega;

    @OneToMany
    private List<ItemPedido> itensPedidos;

    @Column(name = "status_pedido")
    private StatusPedidoEnum statusPedido;

    @ManyToOne
    private Endereco endereco;


}
