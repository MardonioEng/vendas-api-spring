package io.github.devmarodrigues.service;

import io.github.devmarodrigues.domain.entity.Pedido;
import io.github.devmarodrigues.domain.enums.StatusPedido;
import io.github.devmarodrigues.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {

    Pedido salvar(PedidoDTO pedidoDTO);
    Optional<Pedido> obterPedidoCompleto(Integer id);
    void atualizaStatus(Integer id, StatusPedido statusPedido);

}
