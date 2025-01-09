package com.support.baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

    public class Base {
        public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
        public Properties properties;

        @BeforeSuite
        public void setUp() throws IOException {
            properties = new Properties();
            FileInputStream fis = new FileInputStream("src/test/resources/utilities/data.properties");
            properties.load(fis);

            String browser = properties.getProperty("browser");
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless", "--disable-gpu");
                driver.set(new ChromeDriver(options));
                System.out.println("ChromeDriver initialized successfully.");
            } else if (browser.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
                System.out.println("EdgeDriver is initialized successfully.");
            }

            if (driver.get() == null) {
                throw new IllegalStateException("WebDriver initialization failed!");
            }

            System.out.println("Driver initialized successfully.");
            getDriver().manage().window().maximize();
            getDriver().get(properties.getProperty("url"));
        }

        public static WebDriver getDriver()
        {
            if (driver.get() == null) {
                throw new IllegalStateException("Driver is not initialized!");
            }
            return driver.get();
        }

        @AfterSuite
        public void tearDown()
        {
            if (getDriver() != null) {
                getDriver().quit();
                driver.remove();
            }
        }
    }

