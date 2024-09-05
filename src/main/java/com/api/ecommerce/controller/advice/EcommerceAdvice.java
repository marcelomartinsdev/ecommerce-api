package com.api.ecommerce.controller.advice;

import com.api.ecommerce.controller.BaseController;
import com.api.ecommerce.dto.BaseResponseDTO;
import com.api.ecommerce.exceptions.EcommerceExceptions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EcommerceAdvice extends BaseController {
    @ExceptionHandler(EcommerceExceptions.class)
    public ResponseEntity<BaseResponseDTO> ecommerceAdvice(EcommerceExceptions exceptions){
        return err(exceptions.getStatus().value(), exceptions.getErrors().get("mensagem"));
    }
}
