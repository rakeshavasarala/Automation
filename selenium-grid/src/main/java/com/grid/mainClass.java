package com.grid;


import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class mainClass {


    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\UC181532\\Downloads\\chromedriver_win32\\chromedriver.exe");

        System.out.println(System.getProperty("webdriver.chrome.driver"));

        URL hubUrl = new URL("http://localhost:4444/wd/hub");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        capabilities.setPlatform(Platform.WINDOWS);
        WebDriver driver = new RemoteWebDriver(hubUrl, capabilities);


        String configWebUrl = "https://endeavour-configuration-web-autonajenkins.endeavourdemo.com";

        driver.get(configWebUrl);

        //driver.close();

        DesiredCapabilities capabilities1 = new DesiredCapabilities();
        capabilities1.setBrowserName("firefox");
        capabilities1.setPlatform(Platform.WINDOWS);
        WebDriver driver1 = new RemoteWebDriver(hubUrl, capabilities1);

        driver1.get(configWebUrl);

        //driver1.close();

        Thread.sleep(2000);

    }


}
