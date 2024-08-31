package com.api.ecommerce.controller;

import com.api.ecommerce.dto.BaseResponseDTO;
import com.api.ecommerce.dto.PedidoRequestDTO;
import com.api.ecommerce.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController extends BaseController{

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<BaseResponseDTO> save(@RequestBody PedidoRequestDTO pedidoRequestDTO) {
        return ok(pedidoService.cadastroPedido(pedidoRequestDTO));
    }
}
