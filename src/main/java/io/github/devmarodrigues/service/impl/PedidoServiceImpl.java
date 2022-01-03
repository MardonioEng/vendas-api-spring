package io.github.devmarodrigues.service.impl;

import io.github.devmarodrigues.domain.entity.Cliente;
import io.github.devmarodrigues.domain.entity.ItemPedido;
import io.github.devmarodrigues.domain.entity.Pedido;
import io.github.devmarodrigues.domain.entity.Produto;
import io.github.devmarodrigues.domain.enums.StatusPedido;
import io.github.devmarodrigues.domain.repository.ClientesRepository;
import io.github.devmarodrigues.domain.repository.ItemsPedidoRepository;
import io.github.devmarodrigues.domain.repository.PedidosRepository;
import io.github.devmarodrigues.domain.repository.ProdutosRepository;
import io.github.devmarodrigues.exception.PedidoNaoEncontradoException;
import io.github.devmarodrigues.exception.RegraNegocioException;
import io.github.devmarodrigues.rest.dto.ItemPedidoDTO;
import io.github.devmarodrigues.rest.dto.PedidoDTO;
import io.github.devmarodrigues.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidosRepository pedidosRepository;
    @Autowired
    private ClientesRepository clientesRepository;
    @Autowired
    private ProdutosRepository produtosRepository;
    @Autowired
    private ItemsPedidoRepository itemsPedidoRepository;

    @Override
    @Transactional
    public Pedido salvar(PedidoDTO pedidoDTO) {
        Integer idCliente = pedidoDTO.getCliente();
        Cliente cliente = clientesRepository
                                .findById(idCliente)
                                .orElseThrow(() -> new RegraNegocioException("Código de cliente inválido!"));

        Pedido pedido = new Pedido();
        pedido.setTotal(pedidoDTO.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);
        pedido.setStatus(StatusPedido.REALIZADO);

        List<ItemPedido> itemsPedidos = converterItems(pedido, pedidoDTO.getItems());
        pedidosRepository.save(pedido);
        itemsPedidoRepository.saveAll(itemsPedidos);
        pedido.setItens(itemsPedidos);

        return pedido;
    }

    @Override
    public Optional<Pedido> obterPedidoCompleto(Integer id) {
        return pedidosRepository.findByIdFetchItens(id);
    }

    @Override
    @Transactional
    public void atualizaStatus(Integer id, StatusPedido statusPedido) {
        pedidosRepository.findById(id)
                .map(pedido -> {
                    pedido.setStatus(statusPedido);
                    return pedidosRepository.save(pedido);
                }).orElseThrow(() -> new PedidoNaoEncontradoException());
    }

    private List<ItemPedido> converterItems(Pedido pedido, List<ItemPedidoDTO> items) {
        if(items.isEmpty()) {
            throw new RegraNegocioException("Não é possível realizar um pedido sem items.");
        }
        return items.stream()
                .map(dto -> {
                   Integer idProduto = dto.getProduto();
                   Produto produto = produtosRepository.findById(idProduto)
                           .orElseThrow(() -> new RegraNegocioException("Código de produto inválido: " + idProduto));

                   ItemPedido itemPedido = new ItemPedido();
                   itemPedido.setQuantidade(dto.getQuantidade());
                   itemPedido.setPedido(pedido);
                   itemPedido.setProduto(produto);
                   return itemPedido;
                }).collect(Collectors.toList());
    }
}
