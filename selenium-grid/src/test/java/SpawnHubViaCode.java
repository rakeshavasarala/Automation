import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import org.openqa.grid.common.GridRole;
import org.openqa.grid.common.RegistrationRequest;
import org.openqa.grid.common.SeleniumProtocol;
import org.openqa.grid.internal.utils.GridHubConfiguration;
import org.openqa.grid.internal.utils.SelfRegisteringRemote;
import org.openqa.grid.web.Hub;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * Does not seem to work. Its much easier to launch using the json config files.
 */
public class SpawnHubViaCode {
    String hubHost = "localhost";
    int hubPort = 4444;
    Hub myHub = null;
    SelfRegisteringRemote remoteWebDriverNode = null, remoteRCNode = null;


    private String hubConfigJson = "{\n"
            + "  \"host\": null,\n"
            + "  \"port\": 4444,\n"
            + "  \"newSessionWaitTimeout\": -1,\n"
            + "  \"servlets\" : [],\n"
            + "  \"prioritizer\": null,\n"
            + "  \"capabilityMatcher\": \"org.openqa.grid.internal.utils.DefaultCapabilityMatcher\",\n"
            + "  \"throwOnCapabilityNotPresent\": true,\n"
            + "  \"nodePolling\": 5000,\n"
            + "\n"
            + "  \"cleanUpCycle\": 5000,\n"
            + "  \"timeout\": 300000,\n"
            + "  \"browserTimeout\": 0,\n"
            + "  \"maxSession\": 5,\n"
            + "  \"jettyMaxThreads\":-1\n"
            + "}";


    private String nodeConfig = "{\n"
            + "  \"capabilities\":\n"
            + "      [\n"
            + "        {\n"
            + "          \"browserName\": \"firefox\",\n"
            + "          \"maxInstances\": 5,\n"
            + "          \"seleniumProtocol\": \"WebDriver\"\n"
            + "        }\n"
            + "      ],\n"
            + "  \"configuration\":\n"
            + "  {\n"
            + "    \"proxy\": \"org.openqa.grid.selenium.proxy.DefaultRemoteProxy\",\n"
            + "    \"maxSession\": 5,\n"
            + "    \"port\": 5555,\n"
            + "    \"host\": ip,\n"
            + "    \"register\": true,\n"
            + "    \"registerCycle\": 5000,\n"
            + "    \"hubPort\": 4444,\n"
            + "    \"hubHost\": ip\n"
            + "  }\n"
            + "}";


    //@BeforeClass
    public void bringUpHubAndNode() throws Exception {
        GridHubConfiguration gridHubConfig = new GridHubConfiguration();
        gridHubConfig.setHost(hubHost);
        gridHubConfig.setPort(hubPort);
        myHub = new Hub(gridHubConfig);
        myHub.start();

        DesiredCapabilities chrome = new DesiredCapabilities();
        chrome.setBrowserName("chrome");
        chrome.setPlatform(Platform.LINUX);
        remoteRCNode = attachNodeToHub(chrome, GridRole.NODE, 5559,
                SeleniumProtocol.WebDriver);

        /*DesiredCapabilities capabilities1 = new DesiredCapabilities();
        capabilities1.setBrowserName("firefox");
        capabilities1.setPlatform(Platform.LINUX);
        remoteWebDriverNode = attachNodeToHub(capabilities1,
                GridRole.NODE, 5560, SeleniumProtocol.WebDriver);*/
    }

    private SelfRegisteringRemote attachNodeToHub(
            DesiredCapabilities capability, GridRole role, int nodePort,
            SeleniumProtocol protocol) throws Exception {
        SelfRegisteringRemote node = null;
        RegistrationRequest registrationRequest = RegistrationRequest.getNewInstance(nodeConfig);
        capability.setCapability("seleniumProtocol", protocol);
        registrationRequest.addDesiredCapability(capability);
        registrationRequest.setRole(role);
        /*registrationRequest.setConfiguration(fetchNodeConfiguration(role,
                nodePort, protocol));*/
        node = new SelfRegisteringRemote(registrationRequest);
        node.startRemoteServer();
        node.startRegistrationProcess();
        return node;
    }
/*
    private Map<String, Object> fetchNodeConfiguration(GridRole role,
                                                       int portToRun, SeleniumProtocol protocol)
            throws MalformedURLException {
        Map<String, Object> nodeConfiguration = new HashMap<String, Object>();
        nodeConfiguration.put(RegistrationRequest.AUTO_REGISTER, true);
        nodeConfiguration.put(RegistrationRequest.HUB_HOST, myHub.getHost());
        nodeConfiguration.put(RegistrationRequest.HUB_PORT, myHub.getPort());
        nodeConfiguration.put(RegistrationRequest.PORT, portToRun);
        URL remoteURL = new URL("http://" + myHub.getHost() + ":" + portToRun);
        nodeConfiguration.put(RegistrationRequest.PROXY_CLASS,
                "org.openqa.grid.selenium.proxy.DefaultRemoteProxy");
        nodeConfiguration.put(RegistrationRequest.MAX_SESSION, 1);
        nodeConfiguration.put(RegistrationRequest.CLEAN_UP_CYCLE, 2000);
        nodeConfiguration.put(RegistrationRequest.REMOTE_HOST, remoteURL);
        nodeConfiguration.put(RegistrationRequest.MAX_INSTANCES, 1);
        return nodeConfiguration;
    }*/

    @Test
    public void testLocalGrid() throws MalformedURLException {
        URL remoteURL = new URL("http://" + myHub.getHost() + ":" +
                myHub.getPort() + "/wd/hub");
        WebDriver myDriver = new RemoteWebDriver(remoteURL,
                DesiredCapabilities.firefox());
        myDriver.get("http://www.google.com");
        myDriver.quit();
        Selenium selenium = new DefaultSelenium(myHub.getHost(),
                myHub.getPort(), "*googlechrome", "http://www.google.com");
        selenium.start();
        selenium.open("http://www.facebook.com");
        selenium.stop();
    }

    @AfterClass
    public void shutDownNodeAndHub() throws Exception {
        if (remoteWebDriverNode != null) {
            remoteWebDriverNode.stopRemoteServer();
            Reporter.log("WebDriver Node shutdown", true);
        }
        if (remoteRCNode != null) {
            remoteRCNode.stopRemoteServer();
            Reporter.log("RC Node shutdown", true);
        }
        if (myHub != null) {
            myHub.stop();
            Reporter.log("Local hub shutdown", true);
        }
    }
}