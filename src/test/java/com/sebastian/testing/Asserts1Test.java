package com.sebastian.testing;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Assumptions: prevenir que test sean ejecutados.
 * 
 * @author Sebastián Ávila A.
 */
public class Asserts1Test {
  
  @BeforeAll
  static void assumptions() {
    assumeTrue(System.getProperty("os.name").equals("Linux"));
    assumingThat(System.getProperty("os.arch").equals("amd64"), () -> {
      System.out.println("assumming that");
      assertTrue(System.nanoTime() > 1);
    });
  }
  
  @Test
  @DisplayName("assertall")
  void assertall() {
    assertAll("todos se ejecutan", () -> assertTrue(true), () -> assertNull(null));
  }

  @Test
  @DisplayName("assert supplier")
  void assertsup() {
    assertFalse(false, () -> "supplier mensaje");
  }

  @Test
  @DisplayName("assert timeout")
  void asserttimeout() {
    assertTimeout(Duration.ofSeconds(2), () -> {
      final var tm = ThreadLocalRandom.current().nextInt(500, 2000);
      System.out.printf("timeout: %d",  tm);
      Thread.sleep(tm);
    }, () -> "error de timeout");
  }
  
  @Test
  @DisplayName("assert se ejecuta de manera preventiva")
  void assertpreemptively() {
    assertTimeoutPreemptively(Duration.ofSeconds(2), () -> {
      final var tm = ThreadLocalRandom.current().nextInt(500, 2000);
      System.out.printf("preventiva: %d",  tm);
      Thread.sleep(tm);
    }, () -> "error preventiva");
  }
  
  @Test
  @DisplayName("assert exception")
  void assertexception() {
    assertThrows(NullPointerException.class, () -> {
      throw new NullPointerException();
    });
  }
}
