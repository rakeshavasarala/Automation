import com.testng.RpnCalculator;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.testng.Assert.assertEquals;
@ContextConfiguration("classpath:cucumber.xml")
@Component
public class RpnCalculatorStepdefs {
    private RpnCalculator calc;

    @Given("^a calculator I just turned on$")
    public void a_calculator_I_just_turned_on() {
        calc = new RpnCalculator();
    }

    @When("^I add (\\d+) and (\\d+)$")
    public void adding(int arg1, int arg2) {
        calc.push(arg1);
        calc.push(arg2);
        calc.push("+");
    }

    @Given("^I press (.+)$")
    public void I_press(String what) {
        calc.push(what);
    }

    @Then("^the result is (\\d+)$")
    public void the_result_is(double expected) {
        assertEquals(expected, calc.value());
    }

    @Before({"~@foo"})
    public void before() {
        System.out.println("Runs before scenarios *not* tagged with @foo");
    }

    @Before()
    public void beforeAllTests(Scenario scenario) {
        System.out.println("Running Scenario " + scenario.getId());
    }

    @After
    public void after(Scenario scenario) {
        System.out.println("Scenario " + scenario.getId() + " executed");
    }

    @Given("^the previous entries:$")
    public void thePreviousEntries(List<Entry> entries) {
        for (Entry entry : entries) {
            calc.push(entry.first);
            calc.push(entry.second);
            calc.push(entry.operation);
        }
    }

    public class Entry {
        Integer first;
        Integer second;
        String operation;
    }
}