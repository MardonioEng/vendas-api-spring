package io.github.devmarodrigues.domain.repository;

import io.github.devmarodrigues.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<Produto, Integer> {
}
