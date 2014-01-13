package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: Rakesh
 * Date: 07/12/13
 * Time: 21:44
 * To change this template use File | Settings | File Templates.
 */
@Component
public class ConfigWebLoginPage3 extends AbstractPage {


    public By username() {
        return By.id("username");
    }

    public By password() {
        return By.id("password");
    }

    public By login() {
        return By.name("login");
    }



}
