package com.ui.jUnit.pages;

import org.openqa.selenium.By;

/**
 * Created with IntelliJ IDEA.
 * User: Rakesh
 * Date: 07/12/13
 * Time: 20:58
 * To change this template use File | Settings | File Templates.
 */
public final class ConfigWebLoginPage2 {


    public static By username() {
        return By.id("username");
    }

    public static By password() {
        return By.id("password");
    }

    public static By loginButton() {
        return By.name("login");
    }

}
