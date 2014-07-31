package com.ui.jUnit.pages;

import com.ui.drivers.CustomWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class AbstractPage {

    @Autowired
    private CustomWebDriver remoteWebDriver;

    @PostConstruct
    public void init() {
        System.out.println("Inside AbstractPage class, CustomWebDriver = " + remoteWebDriver);
    }

    public void navigateTo(String url) {
        getDriver().get(url);
    }

    public WebDriver getDriver() {
        return remoteWebDriver.getRemoteWebDriver();
    }

    public WebElement elementById(String id) {
        return getDriver().findElement(By.id(id));
    }

    public WebElement elementByClassName(String className) {
        return getDriver().findElement(By.className(className));
    }

}
