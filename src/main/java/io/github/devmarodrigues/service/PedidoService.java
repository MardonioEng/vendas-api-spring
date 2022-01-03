package io.github.devmarodrigues.service;

import io.github.devmarodrigues.domain.entity.Pedido;
import io.github.devmarodrigues.rest.dto.PedidoDTO;

public interface PedidoService {

    Pedido salvar(PedidoDTO pedidoDTO);

}
