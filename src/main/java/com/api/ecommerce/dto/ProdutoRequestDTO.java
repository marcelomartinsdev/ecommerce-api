package com.api.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProdutoRequestDTO {
    @NotBlank(message = "O campo name nao pode estar vazio!")
    private String nome;
    @NotBlank(message = "O campo name nao pode estar vazio!")
    private String descricao;
    @NotBlank(message = "O campo name nao pode estar vazio!")
    private int preco;
    @NotBlank(message = "O campo name nao pode estar vazio!")
    private int quantidadeEstoque;
}
