package com.projedata;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

public class Funcionario extends Pessoa {

  @Getter
  @Setter
  private BigDecimal salario;

  @Getter
  @Setter
  private String funcao;

  public Funcionario(String name, LocalDate dataNascimento, BigDecimal salario, String funcao) {
    super(name, dataNascimento);
    this.salario = salario;
    this.funcao = funcao;
  }

}
