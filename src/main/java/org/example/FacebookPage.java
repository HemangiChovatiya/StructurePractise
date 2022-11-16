package org.example;

import org.testng.Assert;

public class FacebookPage extends Utils
{
    public void toVerifyUserIsOnFacebookPage()
    {
        Assert.assertTrue("https://www.facebook.com/nopCommerce".contains("facebook"),"User is not on facebook page");
    }

    public void toVerifyUserShouldBeAbleToSwitchFacebookWindowToMainWindow()
    {
        String MainWindow=driver.getWindowHandle();
        driver.switchTo().window(MainWindow);
    }
}
