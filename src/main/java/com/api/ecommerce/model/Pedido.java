package com.api.ecommerce.model;

import com.api.ecommerce.enums.StatusPedido;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Pedido extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pedidoId;
    @ManyToOne
    @JoinColumn(name = "clienteId")
    private Cliente cliente;
    private LocalDateTime dataPedido;
    private double valorTotal;
    @ManyToOne
    @JoinColumn(name = "enderecoEntregaId")
    private Endereco endereco;
    @Enumerated(value = EnumType.STRING)
    private StatusPedido statusPedido;
    private String codigoRastreio;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itemPedidoList;
}
