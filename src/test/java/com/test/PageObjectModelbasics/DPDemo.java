package com.test.PageObjectModelbasics;

import org.testng.annotations.DataProvider;


public class DPDemo {
	@DataProvider(name="testData")
	public Object[][] dataProvFunc(){
		return new Object[][] {
			{"Selenium"},{"TestNG"},{"Automation"}};
		}
}
