package com.sebastian.testing;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class Junit5CustomExtension implements AfterEachCallback, BeforeEachCallback, BeforeAllCallback, AfterAllCallback {

  @Override
  public void beforeEach(ExtensionContext extensionContext) throws Exception {
    System.out.println("""
        %s %s a comenzado""".formatted(this.getClass().getSimpleName(),
        extensionContext.getDisplayName()));
  }

  @Override
  public void afterEach(ExtensionContext extensionContext) throws Exception {
    System.out.println("""
        %s %s finalizado""".formatted(this.getClass().getSimpleName(),
        extensionContext.getDisplayName()));
  }

  @Override
  public void beforeAll(ExtensionContext context) throws Exception {
    System.out.println("before all");
  }

  @Override
  public void afterAll(ExtensionContext context) throws Exception {
    System.out.println("after all");
  }
}
