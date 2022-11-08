package com.frederico.FolhaDePagamento.Domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "HORISTA")
public class Horista extends Funcionario{
    int horasTrabalhadas;
    boolean horasExtras;
    Double salarioHorista;



}
