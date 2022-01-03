package io.github.devmarodrigues.rest.controller;

import io.github.devmarodrigues.domain.entity.ItemPedido;
import io.github.devmarodrigues.domain.entity.Pedido;
import io.github.devmarodrigues.domain.enums.StatusPedido;
import io.github.devmarodrigues.rest.dto.AtualizacaoStatusPedidoDTO;
import io.github.devmarodrigues.rest.dto.InformacaoItemPedidoDTO;
import io.github.devmarodrigues.rest.dto.InformacoesPedidoDTO;
import io.github.devmarodrigues.rest.dto.PedidoDTO;
import io.github.devmarodrigues.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/pedidos")
public class PedidosController {

    private PedidoService pedidoService;

    public PedidosController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save(@RequestBody PedidoDTO pedidoDTO) {
        Pedido pedidoSalvo = pedidoService.salvar(pedidoDTO);
        return pedidoSalvo.getId();
    }

    @GetMapping("/{id}")
    public InformacoesPedidoDTO getById(@PathVariable Integer id) {
        return pedidoService.obterPedidoCompleto(id)
                .map(p -> converter(p))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStatus(@RequestBody AtualizacaoStatusPedidoDTO dto, @PathVariable Integer id) {
        String novoStatus = dto.getNovoStatus();
        pedidoService.atualizaStatus(id, StatusPedido.valueOf(novoStatus));
    }

    private InformacoesPedidoDTO converter(Pedido pedido) {
        return InformacoesPedidoDTO.builder()
                    .codigo(pedido.getId())
                    .dataPedido(pedido.getDataPedido().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                    .cpf(pedido.getCliente().getCpf())
                    .nomeCliente(pedido.getCliente().getNome())
                    .total(pedido.getTotal())
                    .status(pedido.getStatus().name())
                    .items(converter(pedido.getItens()))
                    .build();
    }

    private List<InformacaoItemPedidoDTO> converter(List<ItemPedido> itens) {
        if(CollectionUtils.isEmpty(itens)) {
            return Collections.emptyList();
        }
        return itens.stream()
                .map(item ->
                        InformacaoItemPedidoDTO.builder()
                                .descricaoProduto(item.getProduto().getDescricao())
                                .precoUnitario(item.getProduto().getPreco())
                                .quantidade(item.getQuantidade())
                                .build()
                ).collect(Collectors.toList());
    }

//    @GetMapping
//    public List<Pedido> find(Pedido filtro) {
//        ExampleMatcher matcher = ExampleMatcher
//                .matching()
//                .withIgnoreCase()
//                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
//        Example example = Example.of(filtro, matcher);
//        return pedidosRepository.findAll(example);
//    }
//
//    @GetMapping("/{id}")
//    public Pedido getClienteById(@PathVariable Integer id) {
//        return pedidosRepository
//                .findById(id)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//    }
//
//    @PutMapping("/{id}")
//    public void updade(Integer id, Pedido pedido) {
//        pedidosRepository
//                .findById(id)
//                .map(pedidoExistente -> {
//                    pedido.setId(pedidoExistente.getId());
//                    pedidosRepository.save(pedido);
//                    return pedido;
//                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable Integer id) {
//        pedidosRepository
//                .findById(id)
//                .map(pedido -> {
//                    pedidosRepository.delete(pedido);
//                    return pedido;
//                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//    }

}
