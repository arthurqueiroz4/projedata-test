package com.projedata;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

public class Pessoa {
  @Getter
  @Setter
  private String name;

  @Getter
  @Setter
  private LocalDate dataNascimento;

  public Pessoa(String name, LocalDate dataNascimento) {
    this.name = name;
    this.dataNascimento = dataNascimento;
  }
}
