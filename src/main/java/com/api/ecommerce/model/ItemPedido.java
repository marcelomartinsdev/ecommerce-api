package com.api.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class ItemPedido extends BaseEntity {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pedidoId")
    private Pedido pedido;
    @ManyToOne
    @JoinColumn(name = "produtoId")
    private Produto produto;
    private int quantidade;
    private int precoUnitario;
}

