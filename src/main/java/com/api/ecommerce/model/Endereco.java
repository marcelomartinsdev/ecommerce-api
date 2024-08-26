package com.api.ecommerce.model;

import com.api.ecommerce.enums.TipoEnderecoEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Endereco extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "clienteId")
    private Cliente cliente;
    private String logradouro;
    private int numero;
    private String complemento;
    private String localidade;
    private String uf;
    private String cep;
    private TipoEnderecoEnum tipoEnderecoEnum;
}
