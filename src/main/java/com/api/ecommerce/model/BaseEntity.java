package com.api.ecommerce.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseEntity {
   private LocalDateTime dataInsercao;
   private LocalDateTime dataModificacao;
}
