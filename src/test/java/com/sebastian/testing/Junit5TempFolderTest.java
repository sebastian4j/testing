package com.sebastian.testing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class Junit5TempFolderTest {
  @TempDir
  Path tempDir; // no private

  private static Path createdFile;

  @Test
  public void testTemporaryFolder() throws IOException {
    assertTrue(Files.isDirectory(tempDir));
    createdFile = Files.createFile(tempDir.resolve("createdFile.txt"));
    assertTrue(createdFile.toFile().exists());
  }

  @AfterAll
  public static void afterAll() {
    assertFalse(createdFile.toFile().exists());
  }
}
