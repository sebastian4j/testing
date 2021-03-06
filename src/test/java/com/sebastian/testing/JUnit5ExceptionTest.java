package com.sebastian.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class JUnit5ExceptionTest {
  private Calculator calculator = new Calculator();

  @Test
  public void expectIllegalArgumentException() {
    Throwable throwable = assertThrows(IllegalArgumentException.class, () -> calculator.sqrt(-1));
    assertEquals("no puede ser negativo", throwable.getMessage());

  }

  @Test
  public void expectArithmeticException() {
    Throwable throwable = assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
    assertEquals("no puede dividir por zero", throwable.getMessage());
  }
}
