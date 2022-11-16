package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class NopCommerceNewReleasePage extends Utils
{
    private By _titleField = By.id("AddNewComment_CommentTitle");
    private By _commentField = By.id("AddNewComment_CommentText");
    private By _newCommentButton = By.name("add-comment");
    public void verifyUserIsOnNopCommerceNewReleasePage()
    {
        waitForUrlToBe("https://demo.nopcommerce.com/nopcommerce-new-release",20);
        // Match text link after nopcommerce new release page
        Assert.assertTrue("https://demo.nopcommerce.com/nopcommerce-new-release".contains("nopcommerce-new-release"),"User should be on nopcommerce new release page");
    }
    public void enterDetailsOnNopCommerceNewReleasePage()
    {
        typeText(_titleField,LoadProp.getProperty("NopCommerceNewReleaseTitle"));
        typeText(_commentField,LoadProp.getProperty("NopCommerceNewReleaseComment"));
        clickOnElement(_newCommentButton);

    }


}
