package com.frederico.FolhaDePagamento.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "COMISSIONADO")
public class Comissionado extends Funcionario{
    Double percentualComissao;
    Double salarioBisemanal;
}
