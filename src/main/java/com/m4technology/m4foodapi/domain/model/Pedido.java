package com.m4technology.m4foodapi.domain.model;

import com.m4technology.m4foodapi.domain.enums.StatusPedidoEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal subTotal;
    private BigDecimal taxaFrete;
    private BigDecimal valorTotal;
    private LocalDate dataCriacao;
    private LocalDate dataConfirmacao;
    private LocalDate dataCancelamento;
    private LocalDate dataEntrega;
    @OneToMany
    private List<ItemPedido> itensPedidos;
    @Column(name = "status_pedido")
    private StatusPedidoEnum statusPedido;
    @ManyToOne
    private Endereco endereco;
}
