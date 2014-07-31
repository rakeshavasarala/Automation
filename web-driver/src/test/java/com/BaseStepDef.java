package com;

import com.ui.drivers.CustomWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.PostConstruct;

@ContextConfiguration("classpath:cucumber.xml")
public class BaseStepDef {

    @Autowired
    CustomWebDriver customWebDriver;

    @PostConstruct
    public void setup() {
         System.out.println("Inside @PostConstruct of BaseStepDef , customWebDriver = " + customWebDriver);
    }


}
