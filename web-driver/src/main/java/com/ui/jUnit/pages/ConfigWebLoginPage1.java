package com.ui.jUnit.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfigWebLoginPage1 {

    /**
     * Using Page Factory
     * Problem with this is that if it cannot find the element then it throws NoSuchElementException
     * which makes it unusable in cases if element takes longer to load
     */

    @FindBy(id = "username")
    private WebElement usernameTextField;

    @FindBy(id = "password")
    private WebElement passwordTextField;

    @FindBy(name = "login")
    private WebElement loginButton;


    public void login(String username, String password) {
        usernameTextField.sendKeys(username);
        passwordTextField.sendKeys(password);
        loginButton.click();
    }


}
