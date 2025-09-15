package com.projedata;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Formatter {

  public static String format(double salario) {
    DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
    simbolos.setGroupingSeparator('.');
    simbolos.setDecimalSeparator(',');
    var formato = new DecimalFormat("#,###.##", simbolos);
    return formato.format(salario);
  }

  public static String format(LocalDate date) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    return date.format(formatter);
  }
}
