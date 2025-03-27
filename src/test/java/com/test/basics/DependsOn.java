package com.test.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DependsOn {
	WebDriver driver=new ChromeDriver();
  @Test
  public void f() {
	  driver.get("https://www.google.com/");
  }
  @Test(dependsOnMethods = {"f"})
  public void f1() {
	  driver.findElement(By.name("q")).sendKeys("Depends on",Keys.ENTER);
  }
  @Test(dependsOnMethods = {"f","f1"})
  public void f2() {
	  driver.quit();
  }
}
