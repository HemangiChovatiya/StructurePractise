package org.example;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SearchProductPage extends Utils
{
    // Verify user is on product page
//    public void userIsOnProductPage(String productName)
//    {
//        Assert.assertTrue("https://demo.nopcommerce.com/search?q=".contains("search?q"));
 //   }

    // every product have product name contains
    public void everyProductHaveProductNameContains(String productName)
    {
        List<WebElement> productItem = driver.findElements(By.xpath("//h2[@class=\"product-title\"]"));

        System.out.println(productItem.size());
        for (WebElement element :productItem)
        {
            System.out.println(element.getText());
            Assert.assertTrue(getTextFromElement(By.xpath("//h2[@class=\"product-title\"]")).contains(productName));
        }
    }
}
