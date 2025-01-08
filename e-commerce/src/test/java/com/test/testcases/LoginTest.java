package com.test.testcases;

import com.support.baseTest.Base;
import com.support.pageobjects.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.support.listeners.Listeners.class)
public class LoginTest extends Base {
    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
        Assert.assertEquals(getDriver().getTitle(), "My Account");
        Assert.assertEquals(getDriver().findElement(By.linkText("My Orders")).getText(), "My Orders");
    }

}