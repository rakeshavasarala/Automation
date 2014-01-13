package com.ui.stepDefinitions;

import com.ui.pages.ConfigWebLoginPage3;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: Rakesh
 * Date: 07/12/13
 * Time: 22:46
 * To change this template use File | Settings | File Templates.
 */
public class ConfigWebLogin {


    @Autowired
    private ConfigWebLoginPage3 loginPage3;

    @Given("^login to config web$")
    public void login_to_config_web() throws Throwable {



    }
}
