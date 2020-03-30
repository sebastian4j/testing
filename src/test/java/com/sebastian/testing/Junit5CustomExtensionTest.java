package com.sebastian.testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({Junit5CustomExtension.class})
public class Junit5CustomExtensionTest {
  @Test
  public void m2extension() {
    System.out.println("en el método 1");
  }

  @Test
  public void m1extension() {
    System.out.println("en el método 2");
  }
}
