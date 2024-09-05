package com.api.ecommerce.dto;


import lombok.Data;

import java.util.List;


@Data
public class PedidoRequestDTO {
    private List<ItemPedidoDTO> itemPedidoDTOS;
    private Long clienteId;
}
