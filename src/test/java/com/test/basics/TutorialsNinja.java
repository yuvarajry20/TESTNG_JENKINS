package com.test.basics;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class TutorialsNinja {
    private WebDriver driver;
    SoftAssert softASSERT = new SoftAssert();
    @Test
    public void verify() {
        WebElement title = driver.findElement(By.xpath("//span[text()='My Account']"));
        title.click();

        WebElement acc = driver.findElement(By.xpath("//a[text()='Register']"));
        acc.click();

        String expected = "Register Account";
        String original = driver.getTitle();
        softASSERT.assertEquals(original, expected);

        WebElement qafox = driver.findElement(By.xpath("//a[text()='Qafox.com']"));
        qafox.click();

        String expectedQafoxTitle = "Your Store";
        String actualQafoxTitle = driver.getTitle();
        assertEquals(actualQafoxTitle,expectedQafoxTitle);
        
        softASSERT.assertAll();
    }

    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();
    }



    @AfterTest
    public void afterTest() {
       
            driver.quit();
        }
    }
