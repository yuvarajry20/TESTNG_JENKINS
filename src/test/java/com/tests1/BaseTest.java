package com.tests1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.DashBoardPage;
import com.pages.LoginPage;

public class BaseTest {
	public static WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless");
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
