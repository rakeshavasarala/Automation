package com.ui.stepDefinitions;

import com.enums.CucumberBug;
import com.enums.EndeavourMUTypes;
import com.enums.Member;
import com.enums.PasswordConfigModel;
import com.ui.jUnit.pages.ConfigWebLoginPage3;
import cucumber.api.DataTable;
import cucumber.api.Delimiter;
import cucumber.api.Format;
import cucumber.api.Transpose;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

@ContextConfiguration("classpath:cucumber.xml")
@Component
//@Scope("cucumber-glue")
public class ConfigWebLogin {

    @Autowired
    private ConfigWebLoginPage3 loginPage3;

    @Autowired
    private Navigation navigation;

    @Given("^login to config web$")
    public void login_to_config_web() throws Throwable {
        System.out.println(navigation.getUrl());
        loginPage3.username().sendKeys("admin");
        loginPage3.password().sendKeys("admin");
        loginPage3.login().click();
        sleep(5000);
    }


    @Given("^login to config web as$")
    public void loginToConfigWebAs(DataTable dataTable) throws Throwable {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        Map<String, String> map2 = dataTable.getTableConverter().toMap(dataTable, String.class, String.class);

        for (Map.Entry<String, String> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }


    }

    @And("^read data table as rows$")
    public void readDataTableAsRows(DataTable dataTable) throws Throwable {

        Member member = dataTable.asList(Member.class).get(0);

        System.out.println(member.getSalutation());
        System.out.println(member.getFirstName());
        System.out.println(member.getLastName());
        System.out.println(member.getDob());

    }

    @And("^read data table as columns$")
    public void readDataTableAsColumns(@Transpose List<Member> members) throws Throwable {
        Member member = members.get(0);
        System.out.println(member.getSalutation());
        System.out.println(member.getFirstName());
        System.out.println(member.getLastName());
        System.out.println(member.getDob());
    }


    @And("^read (.*) as enum$")
    public void readAsEnum(EndeavourMUTypes endeavourMUTypes) throws Throwable {
        System.out.println(endeavourMUTypes);
    }

    @When("^I load a table like$")
    public void i_load_a_table_like(final DataTable table) throws Throwable {
        final List<CucumberBug> list = table.asList(CucumberBug.class);

        assertEquals(list.get(0).getDate1(), new LocalDate("2014-06-17"));
        assertEquals(list.get(0).getTime1(), new LocalTime("17:30:00"));
        assertEquals(list.get(0).getDate2(), new LocalDate("2014-06-18"));
    }


    @When("^update the password settings$")
    public void updateThePasswordSettings(@Transpose List<PasswordConfigModel> passwordConfigModels) throws Throwable {
        PasswordConfigModel passwordConfigModel = passwordConfigModels.get(0);
        System.out.println(passwordConfigModel.getMinimumLength());
        System.out.println(passwordConfigModel.getLowercaseAlphaCharactersRequired());
        System.out.println(passwordConfigModel.getUppercaseAlphaCharactersRequired());
        System.out.println(passwordConfigModel.getNumericCharactersRequired());
        System.out.println(passwordConfigModel.getPasswordExpiryPeriod());
        System.out.println(passwordConfigModel.getSpecialCharactersRequired());
        System.out.println(passwordConfigModel.getPasswordHistorySize());
        System.out.println("passwordConfigModel.isForcePasswordChangeOnFirstLogin() = " + passwordConfigModel.isForcePasswordChangeOnFirstLogin());

    }


    @Given("^the users (.*)$")
    public void givenTheUsers(@Delimiter(", ") List<String> strings) throws Throwable {
        System.out.println(strings);
    }


    @Given("^the date is (.*)$")
    public void theDateIsT(@Format("yyyy-MM-dd'T'HH:mm:ss") Date date) throws Throwable {
        System.out.println(date.toString());
    }

    @Given("^the calendar date is (.*)$")
    public void theCalendarDateIsT(@Format("yyyy-MM-dd'T'HH:mm:ss") Calendar cal) throws Throwable {
        System.out.println(cal.getTime().toString());
    }

}
