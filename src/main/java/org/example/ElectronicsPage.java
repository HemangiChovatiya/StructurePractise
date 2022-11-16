package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ElectronicsPage extends Utils
{
    private By _cameraPhoto = By.xpath("//h2[@class=\"title\"]/a[@href=\"/camera-photo\"]");
    public void toVerifyToNavigateToCameraPhotoPage()
    {
        // Check 'Camera & photo' present on home page
        Assert.assertEquals(getTextFromElement(_cameraPhoto),"Camera & photo","Camera & photo should be persent");
        // Click on Camera & Photo on Electronics page
        clickOnElement(_cameraPhoto);
    }


}
