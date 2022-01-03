package io.github.devmarodrigues.rest.dto;

import io.github.devmarodrigues.validation.NotEmptyList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoDTO {

    @NotNull(message = "Informe o código do cliente.")
    private Integer cliente;

    @NotNull(message = "O total do pedido é obrigatório.")
    private BigDecimal total;

    @NotEmptyList(message = "O pedido não pode ser realizado sem ítens.")
    private List<ItemPedidoDTO> items;

}
