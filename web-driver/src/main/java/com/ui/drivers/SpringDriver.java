package com.ui.drivers;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created with IntelliJ IDEA.
 * User: Rakesh
 * Date: 07/12/13
 * Time: 21:28
 * To change this template use File | Settings | File Templates.
 */


public class SpringDriver {

    private RemoteWebDriver remoteWebDriver;

    public SpringDriver(String driverType) {
        this.remoteWebDriver = new FirefoxDriver();
    }

    public RemoteWebDriver getRemoteWebDriver() {
        return remoteWebDriver;
    }

}
