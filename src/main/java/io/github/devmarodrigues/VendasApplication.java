package io.github.devmarodrigues;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VendasApplication {

//    @Bean
//    public CommandLineRunner run(
//            @Autowired PedidosRepository pedidosRepository,
//            @Autowired ClientesRepository clientesRepository
//            ) {
//        return args -> {
//            Cliente cliente1 = new Cliente("Cliente Um", "12345678912");
//            Cliente cliente2 = new Cliente("Cliente Dois", "98765432198");
//            clientesRepository.save(cliente1);
//            clientesRepository.save(cliente2);
//            Pedido pedido1 = new Pedido(cliente1, LocalDate.now(), BigDecimal.valueOf(149.99));
//            Pedido pedido2 = new Pedido(cliente2, LocalDate.now(), BigDecimal.valueOf(945.99));
//            pedidosRepository.save(pedido1);
//            pedidosRepository.save(pedido2);
//        };
//    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
