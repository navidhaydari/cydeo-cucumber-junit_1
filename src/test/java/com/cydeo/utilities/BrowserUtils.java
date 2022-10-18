package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

     /*
    This method will accept int (in seconds ) and execute Thread.sleep
    for given duration
     */

    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }

    /*
    This method accepts 3 arguments.
    Arg1. webdriver
    Arg2. expectedInUrl: for verify if the url contains given String.
         -if condition matches, will break loop.
    Arg3. expectedInTitle to be compared against actualTitle.
    will change the window and get the Title of the nre window and verify it.
     */

    public static void switchWindowAndVerify( String expectedInUrl, String expectedInTitle) {
        Set<String> allWindowsHandles = Driver.getDriver().getWindowHandles();
        for (String each : allWindowsHandles) {

            Driver.getDriver().switchTo().window(each);

            System.out.println("Current URL " + Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)) {
                break;
            }
        }
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }

    /*
    This method accepts a string "expectedTitle" and Asserts if it is true
     */
    public static void verifyTitle( String expectedTitle){

        Assert.assertEquals(Driver.getDriver().getTitle() , expectedTitle);
    }

    /**
     * This method will verify if the current UTL contains expected value.
     * @param expectedInURL
     */

    public static void verifyURLContains(String expectedInURL){
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInURL));

    }

    public static List<String> dropdownOptionsAsString(WebElement dropdownElement){
        Select select = new Select(dropdownElement);
        List<WebElement> actualOptionsAsWebElement = select.getOptions();

        List<String> actualOptionsAsString = new ArrayList<>();

        for (WebElement each : actualOptionsAsWebElement) {
            actualOptionsAsString.add(each.getText());

        }

        return actualOptionsAsString;

    }
}
