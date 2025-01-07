package com.test.testcases;

import com.support.baseTest.Base;
import com.support.pageobjects.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;


@Listeners(com.support.listeners.Listeners.class)
public class LoginTest extends Base {
    @Test
    public void testLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
        Assert.assertEquals("My Orders", getDriver().findElement(By.linkText("My Orders")).getText());
        Thread.sleep(2000);
        String actualText = getDriver().findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span")).getText();
        String expectedText = "Welcome, Neo James!";
        Assert.assertEquals(actualText, expectedText );
    }

}