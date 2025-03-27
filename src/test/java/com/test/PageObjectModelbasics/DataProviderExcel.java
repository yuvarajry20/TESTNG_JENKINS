package com.test.PageObjectModelbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DataProviderExcel {
	private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
	@BeforeMethod
	public void setup() {
		System.out.println("Start test");
		WebDriver driver = getDriver();
		driver=new ChromeDriver();
		driver.get("https://www.bing.com");
		driver.manage().window().maximize();
		setDriver(driver);
	}
  @Test(dataProvider = "excelData", dataProviderClass = DPExcel.class)
  public void search(String keyword,String keyword2) throws InterruptedException {
	  WebDriver driver = getDriver();
	  WebElement txtBox=driver.findElement(By.id("sb_form_q"));
	  txtBox.sendKeys(keyword," ", keyword2);
	  System.out.println("Keyword entered is :"+keyword+" "+keyword2);
	  txtBox.sendKeys(Keys.ENTER);
	  System.out.println("Search results are displayed");
	  System.out.println("RESULT: "+driver.getTitle());
	  Thread.sleep(3000);
	  Assert.assertTrue(driver.getPageSource().contains(keyword));
  }
  @AfterMethod
  public void burnDown() {
	  WebDriver driver = getDriver();
	  driver.quit();
	  removeDriver();
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
