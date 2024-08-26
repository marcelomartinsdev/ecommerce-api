package com.api.ecommerce.dto;

import com.api.ecommerce.enums.TipoEnderecoEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EnderecoRequestDTO {
    @NotBlank(message = "O campo name nao pode estar vazio!")
    private int numero;
    @NotBlank(message = "O campo name nao pode estar vazio!")
    private String complemento;
    @NotBlank(message = "O campo name nao pode estar vazio!")
    private String cep;
    private TipoEnderecoEnum tipoEnderecoEnum;
}
