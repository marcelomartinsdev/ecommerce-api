package com.api.ecommerce.service.mapper;

import com.api.ecommerce.dto.EnderecoResponseDTO;
import com.api.ecommerce.model.Endereco;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EnderecoMapper {
    private final ModelMapper mapper;

    public EnderecoMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Endereco toEndereco(EnderecoResponseDTO enderecoResponseDTO) {
        return mapper.map(enderecoResponseDTO, Endereco.class);
    }
}
