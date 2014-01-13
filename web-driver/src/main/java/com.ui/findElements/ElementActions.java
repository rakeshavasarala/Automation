package com.ui.findElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created with IntelliJ IDEA.
 * User: Rakesh
 * Date: 07/12/13
 * Time: 21:04
 * To change this template use File | Settings | File Templates.
 */
public final class ElementActions {


    public static final void enter(WebDriver driver, By by, String value) {
       driver.findElement(by).sendKeys(value);
    }

    public static final void click(WebDriver driver, By by) {
       driver.findElement(by).click();
    }

}
