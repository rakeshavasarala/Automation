package com.ui.drivers;


import com.ui.Browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created with IntelliJ IDEA.
 * User: Rakesh Avasarala
 * Date: 29/11/13
 * Time: 20:46
 * How to launch different browsers - Selenium Web Driver
 */
public class Drivers {

    public void openGooglePageAndQuit(WebDriver driver) throws InterruptedException {
        driver.get("http://www.google.com");
        Thread.sleep(3000);
        driver.quit();
    }

    public WebDriver getDriverForBrowser(Browsers browser) {
        switch (browser) {

            case firefox:
                return new FirefoxDriver();

            case chrome:
                final String pathToChromeDriver = "C:\\Users\\Rakesh\\Documents\\Development\\JarsAndLibraries\\Selenium\\chromeDriver\\chromedriver.exe";
                System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
                return new ChromeDriver();

            default:
                return null;
        }

    }


}
