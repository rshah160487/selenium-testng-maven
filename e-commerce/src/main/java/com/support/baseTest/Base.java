package com.support.baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public Properties properties;

    @BeforeMethod
    public void setUp() throws IOException {
        properties = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/utilities/data.properties");
        properties.load(fis);

        String browser = properties.getProperty("browser");
        String url = properties.getProperty("url");

        if (driver.get() == null) {
            initializeDriver(browser);
        }

        getDriver().manage().window().maximize();
        getDriver().get(url);
        System.out.println("Driver initialized and navigated to URL successfully.");
    }

    private void initializeDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            if (Boolean.parseBoolean(properties.getProperty("headless", "false"))) {
                options.addArguments("--headless", "--disable-gpu");
            }
            driver.set(new ChromeDriver(options));
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver.set(new EdgeDriver());
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        System.out.println(browser + " WebDriver initialized successfully.");
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            throw new IllegalStateException("Driver is not initialized for this thread!");
        }
        return driver.get();
    }

    @AfterMethod
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}


