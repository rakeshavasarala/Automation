package com.ui.jUnit.pages;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AbstractPage {

    @Autowired
    private com.ui.drivers.SpringDriver driver;

    public WebDriver getDriver() {
        return driver.getRemoteWebDriver();
    }

    public void navigateTo(String url) {
        getDriver().get(url);
    }

}
