package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class AppleMacBookPro13InchPage extends Utils
{
    private By _emailAFriend = By.xpath("//div[@class=\"email-a-friend\"]/button");
    public void toVerifyUserIsOnAppleMacBookPro13InchPage()
    {
        // Check User is on apple-macbook pro 13 inch page
        Assert.assertTrue("https://demo.nopcommerce.com/apple-macbook-pro-13-inch".contains("apple"));
    }

    public void toVerifyEmailAFriendIsClickable()
    {
        // Check Email a friend button is present
        Assert.assertEquals(getTextFromElement(_emailAFriend),"Email a friend","Email a friend should be present");
        // Click on Email a friend button
        clickOnElement(_emailAFriend);
    }



}
