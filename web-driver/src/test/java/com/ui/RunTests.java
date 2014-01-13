package com.ui;


import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(tags = {"@now"},
       // features = "classpath:C:\\Users\\Rakesh\\Documents\\Development\\Projects\\Automation\\web-driver\\src\\test\\resources\\",
        monochrome = true)
public class RunTests {
}