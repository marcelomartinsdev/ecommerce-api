package com.api.ecommerce.repositories;

import com.api.ecommerce.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
