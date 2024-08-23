package com.api.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Cliente extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private LocalDateTime dataNascimento;
    private LocalDateTime dataCadastro;

    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecoList;
}
