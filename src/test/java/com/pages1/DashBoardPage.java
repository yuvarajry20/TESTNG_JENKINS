package com.pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class DashBoardPage extends BasePage {
	public DashBoardPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//h6[text()='Dashboard']")
	public WebElement dashboardTitle;
	public String getHomePagetext() {
		return dashboardTitle.getText();
	}
}
