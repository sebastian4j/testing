package com.sebastian.testing;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 *
 * @author Sebastián Ávila A.
 */
public class Junit4CustomRule extends Statement implements TestRule {
  private Statement base;
  private Description description;
  
  public Junit4CustomRule() {
    System.out.println("construido");
  }
  

  @Override
  public void evaluate() throws Throwable {
    System.out.println(
        this.getClass().getSimpleName() + " " + description.getMethodName() + " comenzando");
    try {
      base.evaluate();
    } finally {
      System.out.println(
          this.getClass().getSimpleName() + " " + description.getMethodName() + " finalizado");
    }
  }

  @Override
  public Statement apply(Statement base, Description description) {
    this.base = base;
    this.description = description;
    return this;
  }
}
