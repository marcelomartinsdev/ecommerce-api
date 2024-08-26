package com.api.ecommerce.service.mapper;

import com.api.ecommerce.dto.CadastroClienteRequestDTO;
import com.api.ecommerce.model.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ClienteMapper {
    private final ModelMapper mapper;


    public ClienteMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Cliente toCliente(CadastroClienteRequestDTO cadastroClienteRequestDTO) {
        return mapper.map(cadastroClienteRequestDTO, Cliente.class);
    }
}
