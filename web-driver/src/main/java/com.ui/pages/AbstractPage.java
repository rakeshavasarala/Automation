package com.ui.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AbstractPage {

    @Autowired
    private com.ui.drivers.SpringDriver driver;

    public WebDriver getDriver() {
        return driver.getRemoteWebDriver();
    }


}
