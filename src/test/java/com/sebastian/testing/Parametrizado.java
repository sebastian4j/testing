package com.sebastian.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author Sebastián Ávila A.
 */
enum ParamEnum {
  ABC, BCD, CDE;
}

public class Parametrizado {

  /**
   * recibe los valores del enum en interaciones, uno a la vez
   */
  @ParameterizedTest
  @EnumSource(ParamEnum.class)
  void paramEnum(ParamEnum pe) {
    System.out.println(pe);
    assertEquals(3, pe.name().length());
  }

  /** exluir valores del enum */
  @ParameterizedTest
  @EnumSource(value = ParamEnum.class, mode = EnumSource.Mode.EXCLUDE, names = {"ABC"})
  void paramEnumExclude(ParamEnum pe) {
    System.out.println(pe);
    assertEquals(3, pe.name().length());
  }

  /**
   * recibe los strings en interaciones, uno a la vez
   */
  @ParameterizedTest
  @ValueSource(strings = {"a b c", "d e f"})
  void paramString(String txt) {
    System.out.println("txt: " + txt);
    assertEquals(3, txt.split(" ").length);
  }
}
