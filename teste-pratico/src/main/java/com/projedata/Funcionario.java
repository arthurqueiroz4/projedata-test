package com.projedata;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa {

  private BigDecimal salario;

  private String funcao;

  public Funcionario(String name, LocalDate dataNascimento, BigDecimal salario, String funcao) {
    super(name, dataNascimento);
    this.salario = salario;
    this.funcao = funcao;
  }

  public BigDecimal getSalario() {
    return salario;
  }

  public String getSalarioFormatado() {
    return Formatter.format(salario.doubleValue());
  }

  public void setSalario(BigDecimal salario) {
    this.salario = salario;
  }

  public String getFuncao() {
    return funcao;
  }

  public void setFuncao(String funcao) {
    this.funcao = funcao;
  }

  @Override
  public String toString() {
    return "Funcionario [nome=" + getNome() + " | dataNascimento="
        + getDataNascimentoFormatado() + " | salario="
        + getSalarioFormatado()
        + " | funcao=" + funcao + "]";
  }

}
