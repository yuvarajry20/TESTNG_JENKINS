package com.test.basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrangeHrm implements ITestListener{
	public void onTestFailure(ITestResult result) {
		System.out.println("The name of the testcase failed is: "+result.getName());
	}
	public void onTestSkipped(ITestResult result) {
		System.out.println("The name of the testcase skipped is: "+result.getName());
	}
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName()+" test case started");
	}
	public void onTestSuccess(ITestResult result) {
		System.out.println("The name of the testcase passed is: "+result.getName());
	}
	WebDriver driver;
  @BeforeTest 
  @Parameters({"browser"})
  public void parametertest(String browser) {
	  if(browser.equals("chrome")) {
		  driver=new ChromeDriver();
	  }else if(browser.equals("firefox")) {
		  driver=new FirefoxDriver();
		  
	  }else if(browser.equals("edge")) {
		  driver=new EdgeDriver();
	  }
	  driver.manage().window().maximize();
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }
  @Test
  @Parameters({"val1","val2"})
  public void loginassert(String val1,String val2) {
	  WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
	  username.sendKeys(val1);
	  WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
	  password.sendKeys(val2);
}
  @AfterTest
  public void beforetest() {
	  driver.quit();
  }
} 
