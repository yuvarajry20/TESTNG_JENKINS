package com.test.basics;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNotSame;
import static org.testng.Assert.assertSame;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterTest;

public class Assert {
  @Test
  public void testAssertion() {
	  String str1 = new String("TestNG");
	  String str2 = new String("TestNG");
	  String str3 = null;
	  String str4 = "TestNG";
	  String str5 = "TestNG";
	  String str6 = new String("Not_TestNG");
	  
	  int val1 = 5;
	  int val2 = 6;
	  
	  assertEquals(str1, str2);
	  System.out.println("Equals Assertions is sucesses");
	  
	  assertNotEquals(str1, str6);
	  System.out.println("Not Equal Assertion sucesfull");
	  
	  assertTrue(val1<val2);
	  System.out.println("True Assertion is sucessfull");
	  
	  assertSame(str4, str5);
	  System.out.println("Assertion Same is Sucessfull");
	  
	  assertFalse(val1>val2);
	  System.out.println("False Assertion is sucessfull");
	  
	  assertNotNull(str1);
	  System.out.println("Assert Not null is sucessfull");
	  
	  assertNotSame(str4, str6);
	  System.out.println("Assertion not Same is Sucessfull");

	  
	  
	  
	  
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
