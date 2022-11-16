package org.example;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Utils
{
    // creating object for driver manager class
    DriverManager driverManager = new DriverManager();

    // Method calling from driver-manager class for open website
    @BeforeMethod
    public void setUp()
    {
        driverManager.openBrowser();
    }

    // Method calling from driver-manager class for close website
    @AfterMethod
    public void tearDown(ITestResult result)
    {
        if(!result.isSuccess())
        {
            captureScreenshot(result.getName());
        }
        driverManager.closeBrowser();
    }
}
