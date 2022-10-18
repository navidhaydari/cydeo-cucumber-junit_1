package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class GoogleStepDefinitions {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @When("user types {string} and clicks enter")
    public void user_types_and_clicks_enter(String searchKeyword) {
        googleSearchPage.searchBox.sendKeys(searchKeyword + Keys.ENTER);

    }
    @Then("user sees {string} in the google title")
    public void user_sees_in_the_google_title(String string) {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = string;
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }



    @When("user types {word} and clicks enter")
    public void user_types_and_clicks_enter2(String searchKeyword) {
        googleSearchPage.searchBox.sendKeys(searchKeyword + Keys.ENTER);

    }
    @Then("user sees {word} in the google title")
    public void user_sees_in_the_google_title2(String string) {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = string;
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }



    @When("user types apple and clicks enter")
    public void user_types_apple_and_clicks_enter() {
        googleSearchPage.searchBox.sendKeys("apple" + Keys.ENTER);

    }
    @Then("user sees apple in the google title")
    public void user_sees_apple_in_the_google_title() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "apple";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }


    @When("user is on Google search page")
    public void user_is_on_google_search_page() {

        Driver.getDriver().get("https://www.google.com");
        Driver.getDriver().findElement(By.id("L2AGLb")).click();
    }
    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {
        String expectedTitle = "Google";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }
}
