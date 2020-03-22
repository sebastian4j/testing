package com.sebastian.testing;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 *
 * @author Sebastián Ávila A.
 */
class CustomStatement extends Statement {

  private Statement base;
  private Description description;

  public CustomStatement(Statement base, Description description) {
    System.out.println("construido");
    this.base = base;
    this.description = description;
  }

  @Override
  public void evaluate() throws Throwable {
    System.out.println(this.getClass().getSimpleName() + " "
            + description.getMethodName() + " comenzando");
    try {
      base.evaluate();
    } finally {
      System.out.println(this.getClass().getSimpleName() + " "
              + description.getMethodName() + " finalizado");
    }
  }
}

public class Junit4CustomRule implements TestRule {

  private Statement base;
  private Description description;

  @Override
  public Statement apply(Statement base, Description description) {
    this.base = base;
    this.description = description;
    return new CustomStatement(base, description);
  }
}
