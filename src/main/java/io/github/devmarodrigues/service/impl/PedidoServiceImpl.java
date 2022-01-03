package io.github.devmarodrigues.service.impl;

import io.github.devmarodrigues.domain.repository.PedidosRepository;
import io.github.devmarodrigues.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidosRepository pedidosRepository;



}
