package com.ui.common;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created with IntelliJ IDEA.
 * User: Rakesh Avasarala
 * Date: 29/11/13
 * Time: 20:46
 * How to launch different browsers - Selenium Web Driver
 */
public class MainClass {

    private RemoteWebDriver webDriver;

    public static void main(String[] args) throws InterruptedException {
        MainClass mainClass = new MainClass();
        mainClass.launchFireFox();
        mainClass.launchChrome();
    }

    public void launchFireFox() throws InterruptedException {
        webDriver = new FirefoxDriver();
        openGooglePage();

    }

    public void launchChrome() throws InterruptedException {
        final String pathToChromeDriver = "C:\\Users\\Rakesh\\Documents\\Development\\JarsAndLibraries\\Selenium\\chromeDriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
        webDriver = new ChromeDriver();
        openGooglePage();
    }

    public void openGooglePage() throws InterruptedException {
        webDriver.get("http://www.google.com");
        Thread.sleep(3000);
        webDriver.quit();
    }

}
