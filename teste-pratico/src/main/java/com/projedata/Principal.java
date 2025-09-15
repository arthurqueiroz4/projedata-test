package com.projedata;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Principal {
  public static void main(String[] args) {
    List<Funcionario> funcionarios = new ArrayList<>();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // 3.1
    funcionarios
        .add(new Funcionario("Maria", LocalDate.parse("18/10/2000", formatter), new BigDecimal("2009.44"), "Operador"));
    funcionarios
        .add(new Funcionario("João", LocalDate.parse("12/05/1990", formatter), new BigDecimal("2284.38"), "Operador"));
    funcionarios.add(
        new Funcionario("Caio", LocalDate.parse("02/05/1961", formatter), new BigDecimal("9836.14"), "Coordenador"));
    funcionarios.add(
        new Funcionario("Miguel", LocalDate.parse("14/10/1988", formatter), new BigDecimal("19119.88"), "Diretor"));
    funcionarios.add(
        new Funcionario("Alice", LocalDate.parse("05/01/1995", formatter), new BigDecimal("2234.68"), "Recepcionista"));
    funcionarios.add(
        new Funcionario("Heitor", LocalDate.parse("19/11/1999", formatter), new BigDecimal("1582.72"), "Operador"));
    funcionarios.add(
        new Funcionario("Arthur", LocalDate.parse("31/03/1993", formatter), new BigDecimal("4071.84"), "Contador"));
    funcionarios
        .add(new Funcionario("Laura", LocalDate.parse("08/07/1994", formatter), new BigDecimal("3017.45"), "Gerente"));
    funcionarios.add(
        new Funcionario("Heloísa", LocalDate.parse("24/05/2003", formatter), new BigDecimal("1606.85"), "Eletricista"));
    funcionarios
        .add(new Funcionario("Helena", LocalDate.parse("02/09/1996", formatter), new BigDecimal("2799.93"), "Gerente"));

    System.out.println("-------------------");

    // 3.2
    funcionarios = funcionarios.stream()
        .filter(f -> !f.getNome().equals("João"))
        .toList();

    System.out.println("-------------------");

    // 3.3
    funcionarios.forEach(System.out::println);

    // 3.4
    funcionarios.forEach(f -> f.setSalario(f.getSalario().multiply(new BigDecimal("1.1"))));

    System.out.println("-------------------");

    // 3.5
    var funcoesAgrupadas = new HashMap<String, List<Funcionario>>();

    funcionarios.stream()
        .map(Funcionario::getFuncao)
        .distinct()
        .forEach(f -> funcoesAgrupadas.put(f, new ArrayList<>()));

    funcionarios.forEach(f -> {
      funcoesAgrupadas.get(f.getFuncao()).add(f);
    });

    System.out.println("-------------------");

    // 3.6
    funcoesAgrupadas.forEach((funcao, funcionariosAgrupados) -> {
      var funcionariosFormatados = String.join(",", funcionariosAgrupados.stream().map(Funcionario::toString).toList());
      System.out.println("Função: " + funcao + " => " + funcionariosFormatados);
    });

    System.out.println("-------------------");

    // 3.8
    funcionarios.stream()
        .filter(f -> f.getDataNascimento().getMonth().equals(Month.OCTOBER)
            || f.getDataNascimento().getMonth().equals(Month.DECEMBER))
        .forEach(System.out::println);

    System.out.println("-------------------");

    // 3.9
    funcionarios.stream()
        .sorted(Comparator.comparing(Funcionario::getDataNascimento))
        .findFirst()
        .ifPresent(System.out::println);

    System.out.println("-------------------");

    // 3.10
    funcionarios.stream()
        .sorted(Comparator.comparing(Funcionario::getNome))
        .forEach(System.out::println);

    System.out.println("-------------------");

    // 3.11
    funcionarios.stream()
        .map(Funcionario::getSalario)
        .reduce(BigDecimal::add)
        .ifPresent(total -> System.out.println("Total dos salários: R$ " + Formatter.format(total.doubleValue())));

    System.out.println("-------------------");

    // 3.12
    var salarioMinimo = Double.valueOf("1212.00");
    record FuncionarioComSalarioMinimo(Funcionario funcionario, Double salarios) {
    }
    funcionarios.stream()
        .map(f -> new FuncionarioComSalarioMinimo(f, f.getSalario().doubleValue() / salarioMinimo))
        .forEach(
            fsm -> System.out.println(
                fsm.funcionario.getNome() + " possui " + String.format("%.2f", fsm.salarios) + " salários mínimos."));

    System.out.println("-------------------");
  }
}
