package framework;

import configuration.SystemProperties;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackDriver extends RemoteWebDriver {

    //protected static final org.slf4j.Logger LOG = LoggerFactory.getLogger(BrowserStackDriver.class);
    private static final String BROWSER_STACK_DRIVER_URL = "http://usmanhussain:kZMyzjYgGConPxfGuQzg@hub.browserstack.com/wd/hub";

    public BrowserStackDriver() {
        super(createURl(), caps());
    }

    private static URL createURl() {
        try {
            return new URL(BROWSER_STACK_DRIVER_URL);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private static Capabilities caps() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String buildName = SystemProperties.getCurrentShortDate() + " "
                + WebDriverDiscovery.getBrowserName() + " "
                + WebDriverDiscovery.getBrowserVersion() + " "
                + WebDriverDiscovery.getOperatingSystem() + " "
                + WebDriverDiscovery.getOs_Version();
        capabilities.setCapability("browser", WebDriverDiscovery.getBrowserName());
        capabilities.setCapability("browser_version", WebDriverDiscovery.getBrowserVersion());
        capabilities.setCapability("os", WebDriverDiscovery.getOperatingSystem());
        capabilities.setCapability("os_version", WebDriverDiscovery.getOs_Version());
        capabilities.setCapability("resolution", "1024x768");
        capabilities.setCapability("build", buildName);
        capabilities.setCapability("browserstack.local", false);
        capabilities.setCapability("browserstack.debug", true);
        capabilities.setCapability("browserstack.ie.noFlash", false);
        capabilities.setCapability("browserstack.ie.enablePopups", true);
        capabilities.setCapability("name", "Thomson Reuters Legal UK&I Automation Tests");
        System.out.println("capabilities : " + capabilities.asMap().toString());
        /*System.out.println(capabilities.getCapability("browser"));
        System.out.println(capabilities.getCapability("browser_version"));
        System.out.println(capabilities.getCapability("os"));
        System.out.println(capabilities.getCapability("os_version"));*/
        return capabilities;
    }

}