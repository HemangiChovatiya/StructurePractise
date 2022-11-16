package org.example;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class HomePage extends Utils
{
    // Creating private locator for home page so no one can use this locator for another page
    private By _register = By.className("ico-register");
    private By _electronics = By.xpath("//ul[@class=\"top-menu notmobile\"]/li[2]/a");
    private By _voteButton = By.id("vote-poll-1");
    private By _facebooklogo = By.xpath("//a[@href=\"http://www.facebook.com/nopCommerce\"]");
    private By _appleMacBookPro13Inch = By.xpath("//h2/a[@href=\"/apple-macbook-pro-13-inch\"]");
    private By _nopCommerceNewReleaseDetailsButton = By.xpath("//div[@class=\"news-items\"]/div[2]/div[3]/a");
    private By _searchStoreField = By.id("small-searchterms");
    private By _searchButton = By.xpath("//button[@type=\"submit\"]");
    public void toVerifyRegisterClickableOnHomePage()
    {
        // Check 'Register' present on home page
        Assert.assertEquals(getTextFromElement(_register),"Register","Register should be present");
        // Click on Register on homepage
        clickOnElement(_register);
    }
    public void toVerifyToNavigateToElectronicsPage()
    {
        // Check 'Electronics' present on home page
        Assert.assertEquals(getTextFromElement(_electronics),"Electronics","Electronics should be present");
        // Click on Electronics on homepage
        clickOnElement(_electronics);
    }
    public  void toVerifyVoteButtonClikableOnHomePage()
    {
        // Check 'VOTE' button present on home page
        Assert.assertEquals(getTextFromElement(_voteButton),"VOTE","VOTE button should be present");
        // Click on vote Button
        clickOnElement(_voteButton);
    }
    public void toVerifyWithoutAnySelectClickOnVoteAcceptAlert()
    {
        // Accept Alert
        driver.switchTo().alert().accept();
    }
    public void toVerifyFacebookLogoClickableOnHomePage()
    {
        // Click on facebook logo on homepage
        clickOnElement(_facebooklogo);
    }
    public void toVerifyNavigateToAppleMacBookPro13InchPage()
    {
        // Check Apple-macbook pro 13 inch is present on home page
        Assert.assertEquals(getTextFromElement(_appleMacBookPro13Inch),"Apple MacBook Pro 13-inch","Apple MacBook Pro 13-inch should be present");
        // Click on Apple-macbook pro 13 inch
        clickOnElement(_appleMacBookPro13Inch);
    }

    public void verifyCurrentCurrencyPricesDisplayedWithCurrencySymbol()
    {
        List<WebElement> productsPrices = driver.findElements(By.xpath("//span[@class=\"price actual-price\"]"));
        System.out.println(productsPrices.size());
        Select select = new Select(driver.findElement(By.id("customerCurrency")));
        select.getAllSelectedOptions();
        for (WebElement element : productsPrices)
        {
            System.out.println(element.getText());
        }
    }

    public void verifyNopCommerceNewReleaseDetailsButtonClickableOnHomePage()
    {
        // Confirm nop commerce new release have details button
        Assert.assertEquals(getTextFromElement(_nopCommerceNewReleaseDetailsButton),"DETAILS","DETAILS button should be present");

        // Click on DETAILS button (nop commerce details)
        clickOnElement(_nopCommerceNewReleaseDetailsButton);
    }

    public void hoveringOverMainCategoryAndThenShouldBeNavigateSubcategoryPage(String category, String subCategory)
    {
        WebElement categoryLink = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[contains(.,'"+category+"')]"));

        String beforeHover = categoryLink.getCssValue("color");
        System.out.println("Before hover over on category colour = "+ beforeHover);

        Actions builder = new Actions(driver);
        Action mouseOverCategory = builder.moveToElement(categoryLink).build();
        mouseOverCategory.perform();

        String afterHover = categoryLink.getCssValue("color");
        System.out.println("After hover over on category colour = "+ afterHover);


        WebElement subCategoryLink = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[contains(.,'"+subCategory+"')]"));

        String bgColorBeforeHover = subCategoryLink.getCssValue("color");
        System.out.println("Before hover over on sub category colour = "+ bgColorBeforeHover);

        Actions builder1 = new Actions(driver);
        Action mouseOverSubCategory = builder.moveToElement(subCategoryLink).build();
        mouseOverCategory.perform();

        String bgColorAfterHover = subCategoryLink.getCssValue("color");
        System.out.println("After hover over on sub category colour = "+ bgColorAfterHover);

        clickOnElement(By.linkText(subCategory));

    }

    public void typeProductNameForFindOnSearchBar(String productName)
    {
        typeText(_searchStoreField,LoadProp.getProperty("ProductName"));
    }
    public void verifySearchButtonIsPresent()
    {
        Assert.assertEquals(getTextFromElement(_searchButton),"SEARCH","SEARCH button should be present");
    }
    public void verifySearchButtonIsClickable()
    {
        clickOnElement(_searchButton);
    }




}

