package com.ui.jUnit.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PageActions {

    @Autowired
    private AbstractPage abstractPage;


    public void waitForElementPresent() {

    }

}
