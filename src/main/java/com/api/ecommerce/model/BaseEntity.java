package com.api.ecommerce.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseEntity {
   @CreationTimestamp
   private LocalDateTime dataInsercao;
   @UpdateTimestamp
   private LocalDateTime dataModificacao;
}
