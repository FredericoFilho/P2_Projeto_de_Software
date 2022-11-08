package com.frederico.FolhaDePagamento.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Getter
@Setter
@Entity

public class Venda {
    String data;
    double valor;

    @OneToOne
    Comissionado comissionado;
}
