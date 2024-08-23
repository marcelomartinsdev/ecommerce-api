package com.api.ecommerce.dto.endereco;

import com.api.ecommerce.dto.cliente.CadastroClienteRequestDTO;
import com.api.ecommerce.enums.TipoEnderecoEnum;
import jakarta.validation.constraints.NotBlank;

public class EnderecoRequestDTO {
    private Long clienteId;
    @NotBlank(message = "O campo name nao pode estar vazio!")
    private String logradouro;
    @NotBlank(message = "O campo name nao pode estar vazio!")
    private int numero;
    @NotBlank(message = "O campo name nao pode estar vazio!")
    private String complemento;
    @NotBlank(message = "O campo name nao pode estar vazio!")
    private String cidade;
    @NotBlank(message = "O campo name nao pode estar vazio!")
    private String estado;
    @NotBlank(message = "O campo name nao pode estar vazio!")
    private String cep;
    private TipoEnderecoEnum tipoEnderecoEnum;
}
