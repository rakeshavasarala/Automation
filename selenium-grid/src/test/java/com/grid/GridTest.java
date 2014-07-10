package com.grid;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest {


    private static final String HUB_URL = "http://localhost:4444/wd/hub";
    private static final String CONFIG_URL = "https://endeavour-configuration-web-autonajenkins.endeavourdemo.com";

    @Test(groups = {"firefox"})
    public void firefoxNodeTest() throws MalformedURLException {
        System.out.println("firefoxNodeTest : Started");
        URL hubUrl = new URL(HUB_URL);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        capabilities.setPlatform(Platform.LINUX);

        WebDriver firefoxDiver1 = new RemoteWebDriver(hubUrl, capabilities);
        firefoxDiver1.get(CONFIG_URL);
        System.out.println("firefoxNodeTest : Launched 1st browser");

        WebDriver firefoxDriver2 = new RemoteWebDriver(hubUrl, capabilities);
        firefoxDriver2.get(CONFIG_URL);
        System.out.println("firefoxNodeTest : Launched 2nd browser");
        System.out.println("firefoxNodeTest : Completed");
    }


    @Test(groups = {"chrome"})
    public void chromeNodeTest() throws MalformedURLException {

        System.out.println("chromeNodeTest : Started");

        URL hubUrl = new URL(HUB_URL);
        DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
        chromeCapabilities.setPlatform(Platform.LINUX);

        WebDriver chromeDriver1 = new RemoteWebDriver(hubUrl, chromeCapabilities);
        chromeDriver1.get(CONFIG_URL);
        System.out.println("chromeNodeTest : Launched 1st browser");

        WebDriver chromeDriver2 = new RemoteWebDriver(hubUrl, chromeCapabilities);
        chromeDriver2.get(CONFIG_URL);
        System.out.println("chromeNodeTest : Launched 2nd browser");
        System.out.println("chromeNodeTest : Completed");
    }

    @Parameters({"browserName"})
    @Test(groups = {"browser"})
    public void nodeTest(String browserName) throws MalformedURLException {


        System.out.println("nodeTest : Started with browser " + browserName);

        URL hubUrl = new URL(HUB_URL);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browserName);
        capabilities.setPlatform(Platform.LINUX);


        WebDriver chromeDriver1 = new RemoteWebDriver(hubUrl, capabilities);
        chromeDriver1.get(CONFIG_URL);
        System.out.println("nodeTest : Launched 1st browser " + browserName);

        WebDriver chromeDriver2 = new RemoteWebDriver(hubUrl, capabilities);
        chromeDriver2.get(CONFIG_URL);
        System.out.println("nodeTest : Launched 2nd browser " + browserName);
        System.out.println("nodeTest : Completed");


    }


}
