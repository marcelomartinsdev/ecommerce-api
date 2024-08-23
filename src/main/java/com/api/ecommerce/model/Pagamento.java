package com.api.ecommerce.model;

import com.api.ecommerce.enums.MetodoPagamento;
import com.api.ecommerce.enums.StatusPagamento;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Pagamento extends BaseEntity {
    @Id
    private Long id;
    @OneToOne
    @JoinColumn(name = "pedidoId")
    private Pedido pedido;
    private int valorPagamento;
    private MetodoPagamento metodoPagamento;
    private int numeroTransacao;
    private StatusPagamento statusPagamento;
}
