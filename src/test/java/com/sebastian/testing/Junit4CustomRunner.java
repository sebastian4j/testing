package com.sebastian.testing;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;


/**
 * JUnit_in_Action_Third_Edition
 *
 * @author Sebastián Ávila A.
 */
public class Junit4CustomRunner extends Runner {

  private final Class<?> testedClass;

  public Junit4CustomRunner(Class<?> testedClass) {
    this.testedClass = testedClass;
  }

  /**
   * datos que posteriormente son exportados.
   *
   * @return
   */
  @Override
  public Description getDescription() {
    return Description
            .createTestDescription(testedClass,
                    this.getClass().getSimpleName() + " description");
  }

  @Override
  public void run(RunNotifier notifier) {
    System.out.println("Running tests with "
            + this.getClass().getSimpleName() + ": " + testedClass);
    try {
      Object testObject = testedClass.newInstance();
      for (Method method : testedClass.getMethods()) {
        if (method.isAnnotationPresent(Test.class)) {
          notifier.fireTestStarted(Description
                  .createTestDescription(testedClass,
                          method.getName()));
          method.invoke(testObject);
          System.out.println(method.getName());
          notifier.fireTestFinished(Description
                  .createTestDescription(testedClass,
                          method.getName()));
          
        }
      }
      
    } catch (InstantiationException | IllegalAccessException
            | InvocationTargetException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
    System.out.println("finalizado");
  }
}
