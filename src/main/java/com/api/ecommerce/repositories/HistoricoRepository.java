package com.api.ecommerce.repositories;

import com.api.ecommerce.model.Historico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoRepository extends JpaRepository<Historico, Long> {
}
