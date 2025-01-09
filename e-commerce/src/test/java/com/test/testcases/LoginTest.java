package com.test.testcases;

import com.support.baseTest.Base;
import com.support.pageobjects.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.support.listeners.Listeners.class)
public class LoginTest extends Base {
    @Test
    public void testLogin() {
        WebDriver driver = Base.getDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
        Assert.assertEquals(Base.getDriver().getTitle(), "My Account");
        Assert.assertEquals(Base.getDriver().findElement(By.linkText("My Orders")).getText(), "My Orders");
    }

}