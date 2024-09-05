package com.api.ecommerce.controller;

import com.api.ecommerce.dto.BaseResponseDTO;
import com.api.ecommerce.dto.CadastroClienteRequestDTO;
import com.api.ecommerce.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController extends BaseController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<BaseResponseDTO> save(@RequestBody CadastroClienteRequestDTO cadastroClienteRequestDTO) {
        return ok(clienteService.cadastroCliente(cadastroClienteRequestDTO));
    }
}
