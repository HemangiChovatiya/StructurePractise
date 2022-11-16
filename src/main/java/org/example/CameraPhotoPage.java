package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CameraPhotoPage extends Utils
{
    public void getProductNameOfCameraPhoto()
    {
        List<WebElement> productName = driver.findElements(By.xpath("//h2[@class=\"product-title\"]"));

        System.out.println(productName.size());
        for (WebElement element :productName)
        {
            System.out.println(element.getText());

        }
    }
}
