package framework;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import java.util.*;

@Scope("prototype")
public class WebDriverDiscovery {

    //protected static final Logger LOG = LoggerFactory.getLogger(WebDriverDiscovery.class);

    private final String driverType;
    private RemoteWebDriver remoteWebDriver;
    private static String operatingSystem;
    private static String os_Version;
    private static String browserName;
    private static String browserVersion;

    private final Map<String, String> browserMap = Collections.unmodifiableMap(new HashMap<String, String>() {{
        put("chrome", "org.openqa.selenium.chrome.ChromeDriver");
        put("firefox", "org.openqa.selenium.firefox.FirefoxDriver");
        put("ie", "org.openqa.selenium.ie.InternetExplorerDriver");
        put("browserStack", "com.thomsonreuters.tests.framework.BrowserStackDriver");
        put("htmlUnit", "org.openqa.selenium.htmlunit.HtmlUnitDriver");
//        put("phantomjs", org.openqa.selenium.phantom)
    }});


    public static String getOperatingSystem() {
        return operatingSystem;
    }

    public static String getOs_Version() {
        return os_Version;
    }

    public static String getBrowserVersion() {
        return browserVersion;
    }

    public static String getBrowserName() {
        return browserName;
    }

    public WebDriverDiscovery(String driverType) {
        this.driverType = driverType;
    }

    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        System.out.println("Entered in to browser initialization......");
        String localBrowserType = browserMap.get(driverType);

        if (null != (localBrowserType)) {
            if (driverType.equalsIgnoreCase("browserStack")) {
                getBrowserStackConfiguration();
            }
            Class<?> retrievedClass = Class.forName(localBrowserType);
            if (retrievedClass.getSuperclass().equals(RemoteWebDriver.class)) {
                this.remoteWebDriver = (RemoteWebDriver) retrievedClass.newInstance();
                this.remoteWebDriver.manage().window().maximize();
            } else {
                throw new IllegalArgumentException("driverType must extends RemoteWebDriver");
            }
        } else {
            throw new UnsupportedOperationException("Unknown driverType. Accepted values are " + browserMap.keySet());
        }
        //LOG.warn(String.format("Browser Name is: %s and it's version is: %s", this.remoteWebDriver.getCapabilities().getBrowserName(), this.remoteWebDriver.getCapabilities().getVersion()));
    }


    public void getBrowserStackConfiguration() {
        String browserConfig = System.getProperty("browserConfig");
        if (StringUtils.isNotBlank(browserConfig)) {
            List<String> commandLineArgumentsList = Arrays.asList(browserConfig.split(","));
            for (String configType : commandLineArgumentsList) {
                if (configType.contains("=")) {
                    String configKey = configType.substring(0, configType.lastIndexOf("="));
                    String configValue = configType.substring(configType.indexOf("=") + 1);

                    switch (configKey) {
                        case "OS":
                            operatingSystem = configValue;
                            break;
                        case "OS_Version":
                            os_Version = configValue;
                            break;
                        case "browserName":
                            browserName = configValue;
                            break;
                        case "browserVersion":
                            browserVersion = configValue;
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }

    public RemoteWebDriver getRemoteWebDriver() {
        return this.remoteWebDriver;
    }

    public void close() {
        this.remoteWebDriver.quit();
    }

}
