package com.api.ecommerce.dto;

import lombok.Data;

@Data
public class EnderecoResponseDTO {
    private String cep;
    private String logradouro;
    private String complemento;
    private String unidade;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String siafi;
}
