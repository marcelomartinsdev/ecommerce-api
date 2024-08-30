package com.api.ecommerce.service;

import com.api.ecommerce.dto.CadastroClienteRequestDTO;
import com.api.ecommerce.model.Cliente;
import com.api.ecommerce.repositories.ClienteRepository;
import com.api.ecommerce.service.mapper.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    private final EnderecoService enderecoService;

    private final ClienteMapper clienteMapper;

    public ClienteService(EnderecoService enderecoService, ClienteMapper clienteMapper) {
        this.enderecoService = enderecoService;
        this.clienteMapper = clienteMapper;
    }

    public String cadastroCliente(CadastroClienteRequestDTO cadastroClienteRequestDTO) {
        Cliente cliente = clienteMapper.toCliente(cadastroClienteRequestDTO);
        cliente.setDataCadastro(LocalDateTime.now());
        cliente.setDataModificacao(LocalDateTime.now());
        cliente.setDataInsercao(LocalDateTime.now());
        clienteRepository.save(cliente);
        enderecoService.salvarEndereco(cadastroClienteRequestDTO.getEnderecoRequestDTOList().get(0), cliente);
        return "Cliente Cadastrado!";
    }

    public Cliente retornarCliente(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente com id: " + id + " não encontrado!"));
    }
}
