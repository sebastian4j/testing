package com.sebastian.testing;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.runner.RunWith;

/**
 *
 * @author Sebastián Ávila A.
 */
@RunWith(Junit4CustomRunner2.class)
public class CalculatorTestCustomRunnerTest {

  @Test
  public void testAdd() {
    Calculator calculator = new Calculator();
    double result = calculator.add(10, 50);
    assertEquals(60, result, 0);
    System.out.println("fin test 1");
  }

  @Test
  public void testAdd2() {
    Calculator calculator = new Calculator();
    double result = calculator.add(10, 50);
    assertEquals(60, result, 0);
    System.out.println("fin test 2");
  }
  
  @AfterClass
  public static void after() {
    System.out.println("fin clase");
  }
}
