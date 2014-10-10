package com.test;

import org.junit.Test;

import java.net.MalformedURLException;

/**
 * Created by UC181532 on 10/10/2014.
 */
public class SecondTest {

    public static final String HUB_URL = "http://localhost:4444/wd/hub";
    public static final String CONFIG_URL = "http://www.google.com";

    @Test
    public void testMethod1() throws MalformedURLException, InterruptedException {

        System.out.println("testMethod1 of TestClass2 : Started");
        Thread.sleep(3000);
        /*URL hubUrl = new URL(HUB_URL);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        capabilities.setPlatform(Platform.WINDOWS);

        WebDriver firefoxDiver1 = new RemoteWebDriver(hubUrl, capabilities);
        firefoxDiver1.get(CONFIG_URL);
        System.out.println("testMethod1 of TestClass2 : Launched 1st browser");

        WebDriver firefoxDriver2 = new RemoteWebDriver(hubUrl, capabilities);
        firefoxDriver2.get(CONFIG_URL);
        System.out.println("testMethod1 of TestClass2 : Launched 2nd browser");*/
        System.out.println("testMethod1 of TestClass2 : Completed");
    }

    @Test
    public void testMethod2() throws MalformedURLException, InterruptedException {

        System.out.println("testMethod2 of TestClass2 : Started");
        Thread.sleep(3000);
        /*URL hubUrl = new URL(HUB_URL);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        capabilities.setPlatform(Platform.WINDOWS);

        WebDriver firefoxDiver1 = new RemoteWebDriver(hubUrl, capabilities);
        firefoxDiver1.get(CONFIG_URL);
        System.out.println("testMethod2 of TestClass2 : Launched 1st browser");

        WebDriver firefoxDriver2 = new RemoteWebDriver(hubUrl, capabilities);
        firefoxDriver2.get(CONFIG_URL);
        System.out.println("testMethod2 of TestClass2 : Launched 2nd browser");*/
        System.out.println("testMethod2 of TestClass2 : Completed");
    }

}
