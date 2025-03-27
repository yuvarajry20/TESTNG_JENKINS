package com.test.basics;

import org.testng.annotations.Test;

public class GroupsDemo {
  @Test(alwaysRun = true, groups = {"regressiontest"})
  public void f() {
	  System.out.println("Login the application");
  }
  @Test(alwaysRun = true, groups = {"regressiontest","smoketest"})
  public void f1() {
	  System.out.println("Access the application");
  }
  @Test(alwaysRun = true, groups = {"regressiontest","smoketest","sanitytest"})
  public void f2() {
	  System.out.println("Logout the application");
  }
}
