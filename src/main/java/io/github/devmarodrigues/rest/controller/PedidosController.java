package io.github.devmarodrigues.rest.controller;

import io.github.devmarodrigues.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/pedidos")
public class PedidosController {

    @Autowired
    private PedidoService pedidoService;

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
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Pedido save(@RequestBody Pedido pedido) {
//        pedido.setDataPedido(LocalDate.now());
//        return pedidosRepository.save(pedido);
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
