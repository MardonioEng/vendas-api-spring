package io.github.devmarodrigues.domain.repository;

import io.github.devmarodrigues.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidosRepository extends JpaRepository<Pedido, Integer> {
}
