package com.api.ecommerce.exceptions;

import lombok.Data;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.HashMap;

@Data
public class EcommerceExceptions extends RuntimeException {
    private final HashMap<String, String> errors;

    @Setter
    private HttpStatus status;

    public EcommerceExceptions(String descricao, HttpStatus status) {
        this.errors = new HashMap<>();
        this.status = status;
        errors.put("status", String.valueOf(status.value()));
        errors.put("mensagem", descricao);
    }
}
