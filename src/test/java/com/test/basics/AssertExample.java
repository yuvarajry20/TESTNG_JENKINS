package com.test.basics;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class AssertExample {
	WebDriver driver=new ChromeDriver();
  @Test
  public void verifyTitle() {
	  String expected="Google";
	  String actual=driver.getTitle();
	  assertEquals(actual, expected);
  }
  @BeforeTest
  public void beforeTest() {
	  driver.manage().window().maximize();
	  driver.get("https://www.google.com/");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
