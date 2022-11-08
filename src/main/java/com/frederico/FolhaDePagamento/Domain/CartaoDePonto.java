package com.frederico.FolhaDePagamento.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity

public class CartaoDePonto {
    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long Id;
    String entrada;
    String saida;

    @OneToOne
    Funcionario funcionario;
}
