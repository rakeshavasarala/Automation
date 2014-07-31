package com.ui.drivers;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.remote.RemoteWebDriver;
import javax.annotation.PostConstruct;

public class CustomWebDriver {

    private RemoteWebDriver remoteWebDriver;
    private String driverType;

    public CustomWebDriver(String driverType) {
        this.driverType = driverType;
    }

    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        if (StringUtils.isNotBlank(driverType)) {

            Class<?> retrievedClass = Class.forName(driverType);

            if (retrievedClass.getSuperclass().equals(RemoteWebDriver.class)) {
                this.remoteWebDriver = (RemoteWebDriver) retrievedClass.newInstance();
            } else {
                throw new IllegalArgumentException("driverType must extends RemoteWebDriver");
            }
        }
        System.out.println(String.format("Browser Name is: %s and it's version is: %s", this.remoteWebDriver.getCapabilities().getBrowserName(), this.remoteWebDriver.getCapabilities().getVersion()));
    }

    public RemoteWebDriver getRemoteWebDriver() {
        return remoteWebDriver;
    }

    public void close() {
        this.remoteWebDriver.close();
    }
}
