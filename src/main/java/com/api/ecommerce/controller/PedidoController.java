package com.api.ecommerce.controller;

import com.api.ecommerce.dto.AdicionarProdutoDTO;
import com.api.ecommerce.dto.BaseResponseDTO;
import com.api.ecommerce.dto.PedidoRequestDTO;
import com.api.ecommerce.dto.RemoverProdutoDTO;
import com.api.ecommerce.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController extends BaseController{

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<BaseResponseDTO> save(@RequestBody PedidoRequestDTO pedidoRequestDTO) {
        return ok(pedidoService.cadastroPedido(pedidoRequestDTO));
    }

    @PutMapping("/finalizar")
    public ResponseEntity<BaseResponseDTO> finalizar(@RequestParam Long id) {
        return ok(pedidoService.finalizarPedido(id));
    }

    @PatchMapping("/adicionar-produto")
    public ResponseEntity<BaseResponseDTO> adicionar(@RequestBody AdicionarProdutoDTO adicionarProdutoDTO) {
        return ok(pedidoService.adicionarProdutoNoPedido(adicionarProdutoDTO));
    }

    @PatchMapping("/remover-produto")
    public ResponseEntity<BaseResponseDTO> remover(@RequestBody RemoverProdutoDTO removerProdutoDTO) {
        return ok(pedidoService.removerProdutoNoPedido(removerProdutoDTO));
    }
}
