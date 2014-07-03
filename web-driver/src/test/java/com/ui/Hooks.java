package com.ui;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * Created by IntelliJ IDEA.
 * User: Rakesh Avasarala
 * Date: 6/30/14
 * Time: 11:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class Hooks {



    @Before
    public void beforeHook(Scenario scenario) {

        System.out.println("Inside Before Hook");

        System.out.println(scenario.getId() + "," + scenario.getName());
        System.out.println(scenario.getSourceTagNames());



    }

    @After
    public void afterHook(Scenario scenario) {

        System.out.println("Inside After Hook");

        System.out.println(scenario.getId() + "," + scenario.getName());
        System.out.println(scenario.getSourceTagNames());
        System.out.println(scenario.getName());
        System.out.println(scenario.isFailed());

    }


}
