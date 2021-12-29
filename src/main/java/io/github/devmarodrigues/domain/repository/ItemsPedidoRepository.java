package io.github.devmarodrigues.domain.repository;

import io.github.devmarodrigues.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsPedidoRepository extends JpaRepository<ItemPedido, Integer> {
}
