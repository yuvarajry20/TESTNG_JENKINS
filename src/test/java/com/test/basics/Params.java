package com.test.basics;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Params {
  @Test
  @Parameters({"val1","val2"})
  public void sum(int v1,int v2) {
	  int finalsum=v1+v2;
	  System.out.println("The final sum "+finalsum);
  }
  @Test
  @Parameters({"val3","val4"})
  public void sum1(int v1,int v2) {
	  int finalsum=v1-v2;
	  System.out.println("The final sum "+finalsum);
  }
}
