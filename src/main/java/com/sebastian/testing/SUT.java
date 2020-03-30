package com.sebastian.testing;

public class SUT {
  private String systemName;

  public SUT(String systemName) {
    this.systemName = systemName;
    System.out
        .println(systemName + " from class " + getClass().getSimpleName() + " is initializing.");
  }

  public boolean canReceiveUsualWork() {
    System.out.println(
        systemName + " from class " + getClass().getSimpleName() + " can receive usual work.");
    return true;
  }

  public boolean canReceiveAdditionalWork() {
    System.out.println("""
        %s from class %s cannot receive additional work.
        """.formatted(systemName, getClass().getSimpleName()));
    return false;
  }

  public void close() {
    System.out.println(systemName + " from class " + getClass().getSimpleName() + " is closing.");
  }
}
