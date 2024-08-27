package com.api.ecommerce.controller;

import com.api.ecommerce.dto.BaseResponseDTO;
import com.api.ecommerce.dto.ProdutoRequestDTO;
import com.api.ecommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController extends BaseController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<BaseResponseDTO> save(@RequestBody ProdutoRequestDTO produtoRequestDTO) {
        return ok(produtoService.cadastroProduto(produtoRequestDTO));
    }
}
