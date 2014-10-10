package com.test;

import org.junit.Test;

import java.net.MalformedURLException;

/**
 * Created by UC181532 on 10/10/2014.
 */
public class FirstTest {

    public static final String HUB_URL = "http://localhost:4444/wd/hub";
    public static final String CONFIG_URL = "http://www.google.com";

    @Test
    public void testMethod1() throws MalformedURLException {

        System.out.println("testMethod1 of TestClass1 : Started");
        /*URL hubUrl = new URL(HUB_URL);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        capabilities.setPlatform(Platform.WINDOWS);

        WebDriver firefoxDiver1 = new RemoteWebDriver(hubUrl, capabilities);
        firefoxDiver1.get(CONFIG_URL);
        System.out.println("testMethod1 of TestClass1 : Launched 1st browser");

        WebDriver firefoxDriver2 = new RemoteWebDriver(hubUrl, capabilities);
        firefoxDriver2.get(CONFIG_URL);
        System.out.println("testMethod1 of TestClass1 : Launched 2nd browser");*/
        System.out.println("testMethod1 of TestClass1 : Completed");
    }

    @Test
    public void testMethod2() throws MalformedURLException {

        System.out.println("testMethod2 of TestClass1 : Started");
        /*URL hubUrl = new URL(HUB_URL);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        capabilities.setPlatform(Platform.WINDOWS);

        WebDriver firefoxDiver1 = new RemoteWebDriver(hubUrl, capabilities);
        firefoxDiver1.get(CONFIG_URL);
        System.out.println("testMethod2 of TestClass1 : Launched 1st browser");

        WebDriver firefoxDriver2 = new RemoteWebDriver(hubUrl, capabilities);
        firefoxDriver2.get(CONFIG_URL);
        System.out.println("testMethod2 of TestClass1 : Launched 2nd browser");*/
        System.out.println("testMethod2 of TestClass1 : Completed");
    }


}
