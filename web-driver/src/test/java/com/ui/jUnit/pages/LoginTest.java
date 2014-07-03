package com.ui.jUnit.pages;

import com.ui.Browsers;
import com.ui.drivers.Drivers;
import com.ui.findElements.ElementActions;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: Rakesh
 * Date: 07/12/13
 * Time: 20:47
 * To change this template use File | Settings | File Templates.
 */
public class LoginTest {

    @Test
    public void test1() {

        WebDriver driver = new Drivers().getDriverForBrowser(Browsers.firefox);

        driver.get("https://endeavour-configuration-web-autodailyjenkins.endeavourdemo.com");
        ConfigWebLoginPage1 loginPage1 = PageFactory.initElements(driver, ConfigWebLoginPage1.class);

        loginPage1.login("admin", "admin");

        System.out.println("Test Complete");

        driver.quit();

    }


    @Test
    public void test2() {

        WebDriver driver = new Drivers().getDriverForBrowser(Browsers.firefox);

        driver.get("https://endeavour-configuration-web-autodailyjenkins.endeavourdemo.com");

        ElementActions.enter(driver, ConfigWebLoginPage2.username(), "admin");
        ElementActions.enter(driver, ConfigWebLoginPage2.password(), "admin");
        ElementActions.click(driver, ConfigWebLoginPage2.loginButton());

        System.out.println("Test Complete");

        driver.quit();

    }


    @Autowired
    private ConfigWebLoginPage3 loginPage3;

    @Test
    public void test3() {
        loginPage3.username().sendKeys("admin");
        loginPage3.password().sendKeys("admin");
        loginPage3.login().click();
    }


}
