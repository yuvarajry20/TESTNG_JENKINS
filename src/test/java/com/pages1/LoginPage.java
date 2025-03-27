package com.pages1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "username")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//h5[text()='Login']")
    WebElement titleText;

    @FindBy(xpath = "//button[text()=' Login ']")
    WebElement login;


	public void login(String strUserName,String strPassword) {
		username.sendKeys(strUserName);
		password.sendKeys(strPassword);
		login.click();;
	}
	
	public String getLoginPageText() {
		return titleText.getText();
	}
 
}
