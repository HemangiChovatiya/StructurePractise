package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegisterResultPage extends Utils
{
    private By _continue = By.xpath("//div[@class=\"buttons\"]/a");
    // Method for wait for url to be on webpage and its wait some second before that going next page
    // This URL after successfully registration
    public void toVerifyUserHasBeenRegisteredSuccessfully()
    {
        waitForUrlToBe("https://demo.nopcommerce.com/registerresult/1?returnUrl=/",20);

        // Match text link after successfully registration
        Assert.assertEquals(getTextFromElement(By.className("result")),"Your registration completed","Your registration not successfully completed");
    }
     public void toVerifyContinueButtonIsClickableForRegisteredUser()
     {
         // Check CONTINUE button is present
         Assert.assertEquals(getTextFromElement(_continue),"CONTINUE","CONTINUE button should be present");
         // Click on CONTINUE button
         clickOnElement(_continue);
     }
}
