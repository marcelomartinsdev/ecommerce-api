package com.api.ecommerce.dto.cliente;

import com.api.ecommerce.dto.endereco.EnderecoRequestDTO;
import com.api.ecommerce.model.BaseEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CadastroClienteRequestDTO extends BaseEntity {
    @NotBlank(message = "O campo name nao pode estar vazio!")
    private String name;
    @NotBlank(message = "O campo name nao pode estar vazio!")
    private String email;
    @NotBlank(message = "O campo name nao pode estar vazio!")
    private String cpf;
    @NotBlank(message = "O campo name nao pode estar vazio!")
    private List<EnderecoRequestDTO> enderecoRequestDTOList;

    private LocalDateTime dataNascimento;
    private LocalDateTime dataCadastro;
}
