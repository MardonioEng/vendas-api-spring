package io.github.devmarodrigues.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table( name = "cliente" )
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", length = 100)
    @NotEmpty(message = "O campo nome é obrigatório.")
    private String nome;

    @Column(name = "cpf", length = 11)
    @NotEmpty(message = "O campor CPF é obrigatório.")
    @CPF(message = "Informe um CPF válido.")
    @Max(value = 11, message = "O campo CPF deve ser menor que ou igual à 11")
    private String cpf;

    @JsonIgnore
    @OneToMany( mappedBy = "cliente" , fetch = FetchType.LAZY )
    private Set<Pedido> pedidos;

}
