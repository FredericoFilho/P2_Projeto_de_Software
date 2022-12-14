package com.frederico.FolhaDePagamento.Domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@DiscriminatorColumn(
        name = "tipo",
discriminatorType = DiscriminatorType.STRING
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Funcionario {

    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long Id;

    String nome;

    String endereco;

    int preferenciaPagamento;
    //0 = cheque em maos
    //1= correio
    //2= deposito bancario

    boolean sindicalista;

    // atributo pendente, apenas foi declarado aqui ate agora
    int agendaDePagamento;
    //                       Default
    //0 = semanalmente     (horistas)
    //1= mensalmente       (assalariados)
    //2= bi-semanalmente   (comissionados)
}
