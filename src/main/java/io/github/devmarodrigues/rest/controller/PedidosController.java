package io.github.devmarodrigues.rest.controller;

import io.github.devmarodrigues.domain.entity.Pedido;
import io.github.devmarodrigues.rest.dto.PedidoDTO;
import io.github.devmarodrigues.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/pedidos")
public class PedidosController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save(@RequestBody PedidoDTO pedidoDTO) {
        Pedido pedidoSalvo = pedidoService.salvar(pedidoDTO);
        return pedidoSalvo.getId();
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
