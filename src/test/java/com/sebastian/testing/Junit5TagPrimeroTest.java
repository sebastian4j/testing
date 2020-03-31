package com.sebastian.testing;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * mvn -Dtest=Junit5TagPrimero,Junit5TagSegundo test -DexcludedGroups=t20
 * 
 * mvn -Dtest=Junit5TagPrimero,Junit5TagSegundo test -Dgroups=t20
 * 
 * @author Sebastián Ávila A.
 *
 */
@Tag("primero")
public class Junit5TagPrimeroTest {
  @Tag("t20")
  @Test
  public void testPrimero() {
    assertTrue(true);
    System.out.println("t20 primero");
  }

  @Tag("t21")
  @Test
  public void testPrimero21() {
    assertTrue(true);
    System.out.println("t21 primero");
  }
}
