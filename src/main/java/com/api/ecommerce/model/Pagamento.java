package com.api.ecommerce.model;

import com.api.ecommerce.enums.StatusPagamento;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Pagamento extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "pedidoId")
    private Pedido pedido;
    private double debitar;
    private Long numeroTransacao;
    @Enumerated(EnumType.STRING)
    private StatusPagamento statusPagamento;
}
