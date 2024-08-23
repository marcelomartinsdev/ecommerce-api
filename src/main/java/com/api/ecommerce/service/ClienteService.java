package com.api.ecommerce.service;

import com.api.ecommerce.dto.cliente.CadastroClienteRequestDTO;
import com.api.ecommerce.model.Cliente;
import com.api.ecommerce.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public String cadastroCliente(CadastroClienteRequestDTO cadastroClienteRequestDTO) {
        Cliente cliente = toCliente(cadastroClienteRequestDTO);


    }


    private Cliente toCliente(CadastroClienteRequestDTO cadastroClienteRequestDTO) {
        Cliente cliente = new Cliente();

        cliente.setName(cadastroClienteRequestDTO.getName());
        cliente.setEmail(cadastroClienteRequestDTO.getEmail());
        cliente.setCpf(cadastroClienteRequestDTO.getCpf());
        cliente.setDataNascimento(cadastroClienteRequestDTO.getDataNascimento());
        cliente.setDataCadastro(cadastroClienteRequestDTO.getDataCadastro());
//        cliente.setEnderecoList(cadastroClienteRequestDTO.getEnderecoRequestDTOList());
        return cliente;
    }

}
