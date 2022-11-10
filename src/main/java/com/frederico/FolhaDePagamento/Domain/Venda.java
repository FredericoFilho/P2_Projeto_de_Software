package com.frederico.FolhaDePagamento.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;

@Getter
@Setter
@Entity

public class Venda {
    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long Id;
    String data;
    Double valor;

    @OneToOne
    Comissionado comissionado;
}
