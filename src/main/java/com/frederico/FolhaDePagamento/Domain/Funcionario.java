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

    //0 = cheque em maos
    //1= correio
    //2= deposito
    int preferenciaPagamento;

    boolean sindicalista;

}
