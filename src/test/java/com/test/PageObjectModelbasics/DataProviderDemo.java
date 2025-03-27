package com.test.PageObjectModelbasics;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class DataProviderDemo {
	private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
//	@DataProvider(name="testData")
//	public Object[][] dataProvFunc(){
//		return new Object[][] {{"Selenium"},{"TestNG"}};
//	}
//  @Test(dataProvider = "testData", dataProviderClass = DPDemo.class)
	@Test(dataProvider = "testData", dataProviderClass = DPClass.class)
  public void search(String Keyword,String Experience) { 
		WebDriver driver = getDriver();
//	  WebElement txtBox=driver.findElement(By.id("sb_form_q"));
//	  txtBox.sendKeys(Keyword);
//	  System.out.println("Keyword entered is: "+Keyword);
//	  txtBox.sendKeys(Keys.ENTER);
	  WebElement txtBox = driver.findElement(By.id("sb_form_q"));
	  txtBox.sendKeys(Keyword + " " + Experience);
	  System.out.println("Keyword entered is: " + Keyword + " " + Experience);
	  txtBox.sendKeys(Keys.ENTER);
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
      wait.until(ExpectedConditions.titleContains(Keyword));
	    String searchResultPageTitle = driver.getTitle();
	    Assert.assertTrue(searchResultPageTitle.contains(Keyword), "Search result page title does not contain the keyword: " + Keyword);
	  System.out.println("Search result is displayed.");
	  
  }
  @BeforeMethod
  public void setup() {
	  System.out.println("Start the test");
	  WebDriver driver = getDriver();
		driver = new ChromeDriver();
		driver.get("https://www.bing.com/");
		driver.manage().window().maximize();
		setDriver(driver);
  }

  @AfterMethod
  public void afterMethod() {
	  WebDriver driver = getDriver();
	  driver.quit();
	  removeDriver();
	  System.out.println("End the test");
  }
  private void setDriver(WebDriver driver) {
      driverThreadLocal.set(driver);
  }

  private WebDriver getDriver() {
      return driverThreadLocal.get();
  }

  private void removeDriver() {
      driverThreadLocal.remove();
  }
}
