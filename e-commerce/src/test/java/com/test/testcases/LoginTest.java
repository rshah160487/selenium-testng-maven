package com.test.testcases;

import com.support.baseTest.Base;
import com.support.pageobjects.LoginPage;
import org.openqa.selenium.By;
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
        Thread.sleep(5000);
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.titleIs("My Account"));
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span")));
        String actualText = getDriver().findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span")).getText();
        String expectedText = "Welcome, Neo James!";
        Assert.assertEquals(actualText, expectedText );
    }

}