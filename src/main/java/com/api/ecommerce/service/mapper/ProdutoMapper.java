package com.api.ecommerce.service.mapper;

import com.api.ecommerce.dto.ProdutoRequestDTO;
import com.api.ecommerce.model.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProdutoMapper {
    private final ModelMapper mapper;


    public ProdutoMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Produto toProduto(ProdutoRequestDTO produtoRequestDTO) {
        return mapper.map(produtoRequestDTO, Produto.class);
    }
}
