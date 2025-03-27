package com.test.basics;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TESTNG_Priority {
  @Test(priority = 1)
  public void a() {
	  System.out.println("hi");
  }
  @Test(enabled = false)
  public void b() {
	  System.out.println("hhh");
  }
  @Test(priority = 4)
  public void c() {
	  System.out.println("yuvaraj");
  }
  @Test(priority = 2, enabled = false)
  public void d() {
	  System.out.println("sdsd");
  }
  @Ignore
  @Test(priority = 5)
  public void e() {
	  System.out.println("5");
  }
}
