package com.api.ecommerce.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseResponseDTO {
    private Integer code;
    private String message;
    private Object data;
}
