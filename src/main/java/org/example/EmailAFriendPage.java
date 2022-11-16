package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class EmailAFriendPage extends Utils
{
    private By _friendEmailField = By.id("FriendEmail");
    private By _personalMessageField = By.id("PersonalMessage");
    private By _sendEmailButton = By.xpath("//div[@class=\"buttons\"]/button");

    public void toVerifyUserIsOnEmailAFriendPage()
    {
        Assert.assertTrue("https://demo.nopcommerce.com/productemailafriend/4".contains("productemailafriend"));
    }
    public void enterADetails()
    {
        typeText(_friendEmailField,LoadProp.getProperty("FriendEmailPart1")+getTimeStamp()+LoadProp.getProperty("FriendEmailPart2"));
        typeText(_personalMessageField,LoadProp.getProperty("PersonalMessageAppleMacBookPro13"));
        clickOnElement(_sendEmailButton);

    }


}
