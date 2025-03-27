package com.tests2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.pages2.HomePage;
import com.pages2.RegisterPage;

public class RegisterTest extends BaseTest {
	HomePage objHome;
	RegisterPage objReg;
	
	
  @Test(dataProvider = "exceldata", dataProviderClass = DPExcel.class)
  public void Register(String KeyWord1,String KeyWord2, String Keyword3, String keyword4,String Keyword5) {
	  objHome=new HomePage(driver);
	  objHome.register();
	  objReg=new RegisterPage(driver);
	  WebElement gender=driver.findElement(By.id("gender-male"));
	  gender.click();
	  WebElement FirstName=driver.findElement(By.id("FirstName"));
	  FirstName.sendKeys(KeyWord1);
	  WebElement LastName=driver.findElement(By.id("LastName"));
	  LastName.sendKeys(KeyWord2);
	  WebElement Email=driver.findElement(By.id("Email"));
	  Email.sendKeys(Keyword3);
	  WebElement Password=driver.findElement(By.id("Password"));
	  Password.sendKeys(keyword4);
	  WebElement ConfirmPassword=driver.findElement(By.id("ConfirmPassword"));
	  ConfirmPassword.sendKeys(Keyword5);
	  Assert.assertTrue(objReg.getRegisterPageText().contains("Register"));
  }
}
