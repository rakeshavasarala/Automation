package com.ui.jUnit.pages;

import org.openqa.selenium.By;

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
