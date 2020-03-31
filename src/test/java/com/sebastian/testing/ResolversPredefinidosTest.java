package com.sebastian.testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

/** @author Sebastián Ávila A. */
public class ResolversPredefinidosTest {

  @Test
  void resolvers(TestReporter tr) {
    tr.publishEntry("test-reporter");
    assertTrue(true);
  }

  @RepeatedTest(
      value = 2,
      name = "{displayName} - repetition {currentRepetition}/{totalRepetitions}")
  @DisplayName("Test add operation")
  void resolvers(RepetitionInfo ri, TestInfo ti) {
    System.out.println("ri: " + ri);
    mostrarinfo(ti);
    assertTrue(true);
  }

  void mostrarinfo(TestInfo ti) {
    System.out.println("display name: " + ti.getDisplayName());
    System.out.println("clase: " + ti.getTestClass().get());
    System.out.println("método: " + ti.getTestMethod().get().getName());
  }
}
