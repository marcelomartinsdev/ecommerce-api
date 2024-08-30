package com.api.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class ItemPedido extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pedidoId")
    private Pedido pedido;
    @ManyToOne
    @JoinColumn(name = "produtoId")
    private Produto produto;
    private int quantidade;
    private double precoUnitario;
}

