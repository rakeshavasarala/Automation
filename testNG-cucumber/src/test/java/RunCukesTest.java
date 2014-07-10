import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(format = "json:target/cucumber-report.json"/*, tags = {"@pass"}*/)
public class RunCukesTest extends AbstractTestNGCucumberTests {
}