package com.sebastian.testing;

import java.io.File;
import java.io.IOException;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

/**
 *
 * @author Sebastián Ávila A.
 */
public class Junit4RuleTempFolder {

  @Rule
  public ExpectedException ee = ExpectedException.none();
  @Rule
  public TemporaryFolder folder = new TemporaryFolder();

  private final Junit4CustomRule mr = new Junit4CustomRule();

  /**
   * una alternativa a @Rule public Junit4CustomRule myRule = new
   * Junit4CustomRule();
   */
  @Rule
  public Junit4CustomRule getMyRule() {
    return mr;
  }

  private final Calculator calculator = new Calculator();
  private static File cfd;
  private static File cfl;

  @Test
  public void expectIllegalArgumentException() {
    System.out.println("método expectIllegalArgumentException");
    ee.expect(IllegalArgumentException.class);
    ee.expectMessage("no puede ser negativo");
    calculator.sqrt(-1);
  }

  @Test
  public void expectArithmeticException() {
    System.out.println("método expectArithmeticException");
    ee.expect(ArithmeticException.class);
    ee.expectMessage("no puede dividir por zero");
    calculator.divide(1, 0);
  }

  @Test
  public void testTemporaryFolder() throws IOException {
    cfd = folder.newFolder("cfd");
    cfl = folder.newFile("cfl.txt");
    assertTrue(cfd.exists());
    assertTrue(cfl.exists());
  }

  @AfterClass
  public static void cleanUpAfterAllTestsRan() {
    System.out.println(cfd);
    System.out.println(cfl);
    assertFalse(cfd.exists());
    assertFalse(cfl.exists());
  }

}
