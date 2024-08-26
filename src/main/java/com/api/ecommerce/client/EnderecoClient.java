package com.api.ecommerce.client;

import com.google.gson.JsonObject;
import feign.Param;
import feign.RequestLine;

public interface EnderecoClient {
    @RequestLine("GET /{cep}/json/")
    JsonObject buscarEndereco(@Param("cep") String cep);
}
