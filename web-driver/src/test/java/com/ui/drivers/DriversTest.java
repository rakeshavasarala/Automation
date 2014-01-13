package com.ui.drivers;
import com.ui.Browsers;
import org.junit.Test;


public class DriversTest {

    @Test
    public void launchFirefox() throws InterruptedException {
        Drivers drivers = new Drivers();
        drivers.openGooglePageAndQuit(drivers.getDriverForBrowser(Browsers.firefox));
    }

    @Test
    public void launchChrome() throws InterruptedException {
        Drivers drivers = new Drivers();
        drivers.openGooglePageAndQuit(drivers.getDriverForBrowser(Browsers.chrome));
    }

}
