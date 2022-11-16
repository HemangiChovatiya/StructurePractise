package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegisterPage extends Utils
{
    // Creating private locator for register page so no one can use this locator for another page
    private By _firstNameField = By.id("FirstName");
    private By _lastNameField = By.id("LastName");
    private By _dateOfBirthDaySelect = By.name("DateOfBirthDay");
    private By _dateOfBirthMonthSelect = By.name("DateOfBirthMonth");
    private By _dateOfBirthYearSelect = By.name("DateOfBirthYear");
    private By _emailField = By.id("Email");
    private By _passWordField = By.id("Password");
    private By _confirmPassWordField = By.id("ConfirmPassword");
    private By _registerSubmitButton = By.id("register-button");

    // Match result for URL for registration page
    public void toVerifyUserIsOnRegisterPage()
    {
        Assert.assertTrue("demo.nopcommerce.com/register?returnUrl=%2F".contains("register"));
    }

    public void enterDetailsForRegistration()
    {
        // wait for element to be clicked on register and wait for some second before that going on next page
        waitForElementToBeClickable(_registerSubmitButton,25);
        // Enter First Name
        typeText(_firstNameField,LoadProp.getProperty("FirstName"));
        // Enter Last Name
        typeText(_lastNameField,LoadProp.getProperty("LastName"));
        // Select Day of Birth
        selectFromDropDownByVisibleText(_dateOfBirthDaySelect,LoadProp.getProperty("DOBDay"));
        // Select Day of Month
        selectFromDropDownByVisibleText(_dateOfBirthMonthSelect,LoadProp.getProperty("DOBMonth"));
        // Select Day of Year
        selectFromDropDownByVisibleText(_dateOfBirthYearSelect,LoadProp.getProperty("DOBYear"));
        // Enter email with unique ID
        typeText(_emailField,LoadProp.getProperty("EmailPart1")+getTimeStamp()+LoadProp.getProperty("EmailPart2"));
        // Enter Password
        typeText(_passWordField,LoadProp.getProperty("Password"));
        // Enter same password for conformation
        typeText(_confirmPassWordField,LoadProp.getProperty("ConfirmPassword"));
        // click on register button on register page

        clickOnElement(_registerSubmitButton);


    }
}
