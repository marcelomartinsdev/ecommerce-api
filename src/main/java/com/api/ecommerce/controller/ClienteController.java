package com.api.ecommerce.controller;

import com.api.ecommerce.dto.cliente.CadastroClienteRequestDTO;
import com.api.ecommerce.dto.cliente.CadastroClienteResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @PostMapping
    public ResponseEntity<CadastroClienteResponseDTO> save(@RequestBody @Valid CadastroClienteRequestDTO cadastroClienteRequestDTO) {
        return ResponseEntity.ok()
    }
}
