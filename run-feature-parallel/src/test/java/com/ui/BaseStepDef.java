package com.ui;

import framework.WebDriverDiscovery;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("classpath:cucumber.xml")
public class BaseStepDef {

    @Autowired
    WebDriverDiscovery webDriverDiscovery;

    protected WebDriver getDriver() {
        return webDriverDiscovery.getRemoteWebDriver();
    }

}