package com.ui.common.findElements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

/**
 * Created with IntelliJ IDEA.
 * User: Rakesh
 * Date: 07/12/13
 * Time: 20:21
 * To change this template use File | Settings | File Templates.
 */
public class DialogUtils {

    private WebDriver driver;

    public DialogUtils(WebDriver driver){
       this.driver = driver;
    }

    public String getAlertDialogMsg() {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    public void acceptDialogIfAppears() {
        try {
            Alert alert = null;
            alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No Alert present");
        }

    }

    public void dismissDialogIfAppears() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

}
