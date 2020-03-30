package com.sebastian.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class JUnit5UTTest {
  private static ResourceForAllTests resourceForAllTests;
  private SUT systemUnderTest;

  /*
   * @AfterAll y @BeforeAll podría no ser estatico si la clase se marca con
   * 
   * @TestInstance(Lifecycle.PER_CLASS)
   */
  @BeforeAll
  static void setUpClass() {
    resourceForAllTests = new ResourceForAllTests("Our resource for all tests");
  }

  @AfterAll
  static void tearDownClass() {
    resourceForAllTests.close();
  }

  @BeforeEach
  void setUp() {
    systemUnderTest = new SUT("Our system under test");
  }

  @AfterEach
  void tearDown() {
    systemUnderTest.close();
  }

  @Test
  void testUsualWork() {
    boolean canReceiveUsualWork = systemUnderTest.canReceiveUsualWork();
    assertTrue(canReceiveUsualWork);
  }

  @Test
  void testAdditionalWork() {
    boolean canReceiveAdditionalWork = systemUnderTest.canReceiveAdditionalWork();
    assertFalse(canReceiveAdditionalWork);
  }

  @Test
  @Disabled
  void mySecondTest() {
    assertEquals(2, 1, "2 is not equal to 1");
  }
}


