package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TestSuit extends BaseTest
{
    // Creating homepage object for using homepage method
    HomePage homePage = new HomePage();
    // Creating register page object for using register page method
    RegisterPage registerPage = new RegisterPage();
    // Creating registerResultPage object for using registerResultPage method
    RegisterResultPage registerResultPage = new RegisterResultPage();
    ElectronicsPage electronicsPage = new ElectronicsPage();

    CameraPhotoPage cameraPhotoPage = new CameraPhotoPage();

    FacebookPage facebookPage = new FacebookPage();
    AppleMacBookPro13InchPage appleMacBookPro13InchPage = new AppleMacBookPro13InchPage();
    EmailAFriendPage emailAFriendPage = new EmailAFriendPage();
    NopCommerceNewReleasePage nopCommerceNewReleasePage = new NopCommerceNewReleasePage();
    SearchProductPage searchProductPage = new SearchProductPage();
    @Test
    public void toVerifyUserShouldAbleToRegisterSuccessfully()
    {
        // Click on 'Register' on home page
        homePage.toVerifyRegisterClickableOnHomePage();
        // Confirm user is on register page
        registerPage.toVerifyUserIsOnRegisterPage();
        // Enter registration details
        registerPage.enterDetailsForRegistration();
        // Verify user has been registered successfully
        registerResultPage.toVerifyUserHasBeenRegisteredSuccessfully();
    }

    @Test
    public void verifyEachProductHasName()
    {
        // Navigate to Electronics page
        homePage.toVerifyToNavigateToElectronicsPage();
        // Navigate to Camera-Photo page
        electronicsPage.toVerifyToNavigateToCameraPhotoPage();
        // Each product has name
        cameraPhotoPage.getProductNameOfCameraPhoto();
    }

    @Test
    public void toVerifyUserShouldBeAbleToOnHomePageWithoutSelectAnyCommunityPollClickOnVoteAndAlertIsDisplayedAndAcceptTheAlert()
    {
        // Click on vote button without select any option on home page
        homePage.toVerifyVoteButtonClikableOnHomePage();
        // Accept the alert
        homePage.toVerifyWithoutAnySelectClickOnVoteAcceptAlert();

    }

    @Test
    public void toVerifyUserShouldBeAbleToSwitchFacebookWindowToMainWindowWhenUserClickonFacebookLogoOnHomePage()
    {
        // Click on facebook logo
        homePage.toVerifyFacebookLogoClickableOnHomePage();
        // Confirm user is on facebook page
        facebookPage.toVerifyUserIsOnFacebookPage();
        // Switch facebook window to homepage
        facebookPage.toVerifyUserShouldBeAbleToSwitchFacebookWindowToMainWindow();
    }
    @Test
    public void toVerifyRegisteredUserShouldBeAbleToReferAppleMacBookPro13InchToAFriendSuccessfully()
    {
        // For Registration
        toVerifyUserShouldAbleToRegisterSuccessfully();
        // Click on CONTINUE button
        registerResultPage.toVerifyContinueButtonIsClickableForRegisteredUser();
        // Click on apple-macbook pro 13 inch
        homePage.toVerifyNavigateToAppleMacBookPro13InchPage();
        // Check User is on apple-macbook pro 13 inch page
        appleMacBookPro13InchPage.toVerifyUserIsOnAppleMacBookPro13InchPage();
        // Click on email a friend button
        appleMacBookPro13InchPage.toVerifyEmailAFriendIsClickable();
        // User is on email a friend page
        emailAFriendPage.toVerifyUserIsOnEmailAFriendPage();
        // Enter details and send email to a friend
        emailAFriendPage.enterADetails();
        // Registered User should be successfully refer a product to a friend
    }
    @Test
    public void toVerifyUserShouldBeAbleToSeePricesWithCurrentCurrencySymbol()
    {
      homePage.verifyCurrentCurrencyPricesDisplayedWithCurrencySymbol();
    }

    @Test
    public void toVerifyUserShouldBeAbleToClickOnNopCommerceNewReleaseDetailsButtonAndUserShouldBeAbleToFillTitleAndCommentAndSuccessfullySubmit()
    {
        homePage.verifyNopCommerceNewReleaseDetailsButtonClickableOnHomePage();
        nopCommerceNewReleasePage.enterDetailsOnNopCommerceNewReleasePage();
    }

    @Test
    public void toVerifyUserShouldAbleToSeeColourDifferenceBeforeHoveringAndAfterHovering()
    {
        homePage.hoveringOverMainCategoryAndThenShouldBeNavigateSubcategoryPage("Computers","Desktops");
    }

    @Test
    public void toVerifyUserShouldAbleToFindProductsOnSearchBar()
    {
        // User should be able to type a product for finding on search bar
        homePage.typeProductNameForFindOnSearchBar(LoadProp.getProperty("ProductName"));

        // Verify search button is present
        homePage.verifySearchButtonIsPresent();

        // Click on search button
        homePage.verifySearchButtonIsClickable();

        // User should be on navigated to product page
        searchProductPage.everyProductHaveProductNameContains(LoadProp.getProperty("ProductName"));
    }
}
