package com.ui.stepDefinitions;

import com.ui.jUnit.pages.ConfigWebLoginPage3;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("classpath:cucumber.xml")
@Component
//@Scope("cucumber-glue")
public class Navigation {

    @Autowired
    private ConfigWebLoginPage3 loginPage3;

    private String url;

    @Given("^navigate to page (.*)$")
    public void navigateToLoginPage(String url) throws Throwable {
        this.url = url;
        loginPage3.navigateTo(url);
    }

    public String getUrl() {
        return url;
    }
}
