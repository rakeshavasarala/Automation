package com.ui.stepDefinition;

import com.ui.BaseStepDef;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;


public class GoogleSearch extends BaseStepDef{

    @Given("^google search page is open$")
    public void googleSearchPageIsOpen() throws Throwable {
        getDriver().get("http://www.google.co.uk");
    }

    @Given("^user types in \"(.*?)\"$")
    public void userTypesIn(String searchTerm) throws Throwable {
        getDriver().findElement(By.id("gbqfq")).sendKeys(searchTerm);
    }

    @Given("^clicks on search button$")
    public void clicksOnSearchButton() throws Throwable {
        getDriver().findElement(By.id("gbqfbw")).click();
    }

}
