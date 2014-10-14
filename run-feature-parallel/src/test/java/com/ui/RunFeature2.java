package com.ui;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:run-feature-parallel/target/cucumber-html-report",
                "json:run-feature-parallel/target/cucumber.json"},
        tags = {"@feature2"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunFeature2 {
}