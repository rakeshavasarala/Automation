package com.ui;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import org.junit.runner.RunWith;

@RunWith(CustomCucumber.class)
@CucumberOptions(
        format = {"pretty", "html:run-feature-parallel/target/cucumber-html-report",
                "json:run-feature-parallel/target/cucumber.json"},
        tags = {"~@wip"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunWithCustomCucumber {
}
