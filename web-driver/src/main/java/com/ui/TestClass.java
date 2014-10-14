package com.ui;

import com.ui.jUnit.pages.ConfigWebLoginPage3;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: Rakesh
 * Date: 07/12/13
 * Time: 21:50
 * To change this template use File | Settings | File Templates.
 */
public class TestClass {

    @Autowired
    private ConfigWebLoginPage3 loginPage3;

    public void test3() throws InterruptedException {
        loginPage3.username().sendKeys("admin");
        loginPage3.password().sendKeys("admin");
        loginPage3.login().click();
    }


    public static void main(String[] args) throws InterruptedException {
        new TestClass().test3();
    }
}
