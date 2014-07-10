package com.grid;


import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class mainClass {


    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        URL hubUrl = new URL("http://localhost:4444/wd/hub");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        capabilities.setPlatform(Platform.LINUX);
        WebDriver driver = new RemoteWebDriver(hubUrl, capabilities);


        String configWebUrl = "https://endeavour-configuration-web-autonajenkins.endeavourdemo.com";

        driver.get(configWebUrl);

        //driver.close();

        DesiredCapabilities capabilities1 = new DesiredCapabilities();
        capabilities1.setBrowserName("chrome");
        capabilities1.setPlatform(Platform.LINUX);
        WebDriver driver1 = new RemoteWebDriver(hubUrl, capabilities1);

        driver1.get(configWebUrl);

        //driver1.close();

        Thread.sleep(2000);

    }


}
