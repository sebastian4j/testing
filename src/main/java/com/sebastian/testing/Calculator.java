package com.sebastian.testing;

public class Calculator {

  public double add(double number1, double number2) {
    return number1 + number2;
  }

  public double sqrt(double x) {
    if (x < 0) {
      throw new IllegalArgumentException("no puede ser negativo");
    }
    return Math.sqrt(x);
  }

  public double divide(double x, double y) {
    if (y == 0) {
      throw new ArithmeticException("no puede dividir por zero");
    }
    return x / y;
  }
}
