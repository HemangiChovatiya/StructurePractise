package org.example;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.HashMap;

public class DriverManager extends Utils
{
    public static final String USERNAME = LoadProp.getProperty("BROWSERSTACK_USERNAME");
    public static final String AUTOMATE_KEY = LoadProp.getProperty("BROWSERSTACK_ACCESS_KEY");
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    String browserName = LoadProp.getProperty("Browser");

    boolean runIncloud = Boolean.parseBoolean(LoadProp.getProperty("Cloud"));
    MutableCapabilities capabilities = new MutableCapabilities();


    // Method for open website
    public void openBrowser()
    {
        // run in cloud===========================================

        if(runIncloud)
        {
            System.out.println("Running in cloud");
            //connect to cloud
            if (browserName.equalsIgnoreCase("Edge")) {
                ///connect with browserstack
                capabilities.setCapability("browserName", "Edge");
                capabilities.setCapability("browserVersion", "106.0");
                HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
                browserstackOptions.put("os", "Windows");
                browserstackOptions.put("osVersion", "10");
                browserstackOptions.put("local", "false");
                browserstackOptions.put("seleniumVersion", "4.1.0");
                capabilities.setCapability("bstack:options", browserstackOptions);
            }
            else if (browserName.equalsIgnoreCase("Safari"))
            {
                ///connect with browserstack
                capabilities.setCapability("browserName", "safari");
                capabilities.setCapability("browserVersion", "10");
                HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
                browserstackOptions.put("os", "ios");
                browserstackOptions.put("osVersion", "11");
                browserstackOptions.put("local", "false");
                browserstackOptions.put("seleniumVersion", "4.1.0");
                capabilities.setCapability("bstack:options", browserstackOptions);
            } else {
                System.out.println("Your browser name is wrong or missing implementation:" + browserName);
            }
            try {
                driver = new RemoteWebDriver(new URL(URL), capabilities);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }

        }else
        {
            System.out.println("Running locally");
            //  run in locally
            if(browserName.equalsIgnoreCase("Chrome"))
            {
                System.setProperty("webdriver.chrome.driver", "src/test/java/Drivers/chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("Edge"))
            {
                System.setProperty("webdriver.edge.driver", "src/test/java/Drivers/msedgedriver.exe");
                driver = new EdgeDriver();
            } else if (browserName.equalsIgnoreCase("Firefox"))
            {
                System.setProperty("webdriver.gecko.driver", "src/test/java/Drivers/geckodriver.exe");
                driver = new FirefoxDriver();
            }else
            {
                System.out.println("Your browser name is wrong or missing:" + browserName);
            }
        }



        // For keep fullscreen
        driver.manage().window().maximize();
        // Enter URL
        driver.get(LoadProp.getProperty("URL"));
    }
    // Method for close website
    public void closeBrowser()
    {
        driver.quit();
    }
}
