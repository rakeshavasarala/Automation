package com.ui.jUnit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: Rakesh
 * Date: 07/12/13
 * Time: 21:44
 * To change this template use File | Settings | File Templates.
 */
@Component
@Scope("thread")
public class ConfigWebLoginPage3 extends AbstractPage {


    public WebElement username() {
        return getDriver().findElement(By.id("username"));
    }

    public WebElement password() {
        return getDriver().findElement(By.id("password"));
    }

    public WebElement login() {
        return getDriver().findElement(By.name("login"));
    }


}
