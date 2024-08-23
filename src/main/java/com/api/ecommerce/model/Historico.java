package com.api.ecommerce.model;

import com.api.ecommerce.enums.StatusPedido;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Historico extends BaseEntity {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pedidoId")
    private Pedido pedido;
    private StatusPedido statusAtualPedido;
}
