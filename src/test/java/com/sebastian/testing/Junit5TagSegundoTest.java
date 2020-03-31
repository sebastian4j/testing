package com.sebastian.testing;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * mvn -Dtest=Junit5TagPrimero,Junit5TagSegundo test -DexcludedGroups=t20
 * @author Sebastián Ávila A.
 *
 */
@Tag("segundo")
public class Junit5TagSegundoTest {
  @Test
  public void testSegundo() {
    assertTrue(true);
    System.out.println("segundo");
  }
  @Tag("t21")
  @Test
  public void testPrimero21() {
    assertTrue(true);
    System.out.println("t21 segundo");
  }
}
