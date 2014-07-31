package com.ui.jUnit.pages;

import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("thread")
public class ConfigWebLoginPage3 extends AbstractPage {

    public WebElement username() {
        return elementById("dummyusername");
    }

    public WebElement password() {
        return elementById("dummypassword");
    }

    public WebElement login() {
        return elementById("login");
    }

    public WebElement logout() {
        return elementByClassName("logout");
    }

}
