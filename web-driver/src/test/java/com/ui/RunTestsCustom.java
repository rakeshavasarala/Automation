package com.ui;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import org.junit.runner.RunWith;

@RunWith(CustomCucumber.class)
@CucumberOptions(tags = {"@now"},
        snippets = SnippetType.CAMELCASE,
        // features = "classpath:C:\\Users\\Rakesh\\Documents\\Development\\Projects\\Automation\\web-driver\\src\\test\\resources\\",
        format = {"pretty", "html:target/cucumber/html", "json:target/cucumber/json/RunTests.json"},
        monochrome = true)
public class RunTestsCustom {
}