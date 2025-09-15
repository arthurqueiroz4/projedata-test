package com.projedata;

import java.time.LocalDate;

public class Pessoa {

  private String nome;

  private LocalDate dataNascimento;

  public Pessoa(String name, LocalDate dataNascimento) {
    this.nome = name;
    this.dataNascimento = dataNascimento;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String name) {
    this.nome = name;
  }

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public String getDataNascimentoFormatado() {
    return Formatter.format(dataNascimento);
  }

  public void setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
  }
}
