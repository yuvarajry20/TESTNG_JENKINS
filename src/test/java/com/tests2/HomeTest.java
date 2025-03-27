package com.tests2;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.pages2.HomePage;

public class HomeTest extends BaseTest {
	HomePage objHome;
	 @Test(priority = 0)
	  public void loginTest() {
		  objHome=new HomePage(driver);
		  String loginPageTitle=objHome.getLoginPageText();
		  Assert.assertTrue(loginPageTitle.contains("Welcome to the new Tricentis store!"));
	  }

}
