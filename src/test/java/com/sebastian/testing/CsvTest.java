package com.sebastian.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

/** @author Sebastián Ávila A. */
public class CsvTest {
  /** un csv es una linea separada por comas */
  @ParameterizedTest
  @CsvSource({"2, Unit testing", "3, JUnit in Action", "4, Write solid Java code"})
  void testWordsInSentence(int expected, String sentence) {
    assertEquals(expected, sentence.split(" ").length);
  }

  /** archivo csv desde el classpath */
  @ParameterizedTest
  @CsvFileSource(resources = "/entrada.csv")
  void testWordsInSentenceFromClasspathFile(int expected, String sentence) {
    assertEquals(expected, sentence.split(" ").length);
  }
}
