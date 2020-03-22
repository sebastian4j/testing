package com.sebastian.testing;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

/**
 * JUnit_in_Action_Third_Edition
 *
 * @author Sebastián Ávila A.
 */
public class Junit4CustomRunner2 extends BlockJUnit4ClassRunner {

  private final Class<?> testedClass;

  public Junit4CustomRunner2(Class<?> testClass) throws InitializationError {
    super(testClass);
    testedClass = testClass;
  }

  @Override
  public void run(RunNotifier notifier) {
    System.out.println("::inicio tests");
    super.run(notifier);
    System.out.println("::fin tests");
  }

}
