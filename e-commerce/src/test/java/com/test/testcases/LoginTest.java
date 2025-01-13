package com.test.testcases;

import com.support.baseTest.Base;
import com.support.pageobjects.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

@Listeners(com.support.listeners.Listeners.class)
public class LoginTest extends Base {
    @Test
    public void validTestLogin() {
        WebDriver driver = Base.getDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
        Assert.assertEquals(driver.getTitle(), "My Account");
        Assert.assertEquals(driver.findElement(By.linkText("My Orders")).getText(), "My Orders");
    }

    @Test
    public void invalidTestLogin() {
        WebDriver driver = Base.getDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("user1","pass1");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("email-error"))));
        String errorMessage = "Please enter a valid email address (Ex: johndoe@domain.com).";
        Assert.assertEquals(driver.findElement(By.id("email-error")).getText(),errorMessage);
        Assert.assertNotEquals(driver.getTitle(), "My Account");
    }
}