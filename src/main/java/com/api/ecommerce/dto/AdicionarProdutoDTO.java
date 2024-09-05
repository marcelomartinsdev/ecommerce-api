package com.api.ecommerce.dto;

import com.api.ecommerce.model.Pedido;
import lombok.Data;

@Data
public class AdicionarProdutoDTO{
    private Long pedidoId;
    private Long produtoId;
    private int quantidadeProduto;
}
