package framework;

import com.gargoylesoftware.htmlunit.AlertHandler;
import com.gargoylesoftware.htmlunit.ConfirmHandler;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

/**
 * This base class should only be used for any UI driven tests.
 */
@Component
public abstract class AbstractTest {

    //protected static final Logger LOG = LoggerFactory.getLogger(AbstractTest.class);
    protected final ConfirmHandler okHandler;
    protected final ConfirmHandler cancelHandler;
    protected AlertHandler alertHandler;
    protected Stack<String> confirmMessages;
    protected Stack<String> alertMessages;
    protected RemoteWebDriver driver;

    private static final String FIELD_NAME_WEB_CLIENT = "webClient";
    private static final int DRIVER_WAIT_TIME = 5;

    @Autowired
    private WebDriverDiscovery webDriverDiscovery;

    @PostConstruct
    public void setupEnvironment() {
        driver = webDriverDiscovery.getRemoteWebDriver();
        driver.manage().timeouts().implicitlyWait(DRIVER_WAIT_TIME, TimeUnit.SECONDS);
        confirmMessages = new Stack<String>();
        alertMessages = new Stack<String>();
    }

    protected AbstractTest() {
        okHandler = new ConfirmHandler() {
            public boolean handleConfirm(Page page, String message) {
                confirmMessages.add(message);
                return true;
            }
        };

        cancelHandler = new ConfirmHandler() {

            public boolean handleConfirm(Page page, String message) {
                confirmMessages.add(message);
                return false;
            }
        };
        alertHandler = new AlertHandler() {

            public void handleAlert(Page page, String message) {
                alertMessages.add(message);
            }
        };
    }

    private Alert alert = null;

    protected void handleAlert(String okOrcancel) {
        if (null == alert) {
            alert = driver.switchTo().alert();
        }
        if ("OK".equals(okOrcancel.toUpperCase())) {
            alert.accept();
        } else if ("CANCEL".equals(okOrcancel.toUpperCase())) {
            alert.dismiss();
        }
    }

    protected boolean isAlertPresent() {
        try {
            alert = driver.switchTo().alert();
        } catch (NoAlertPresentException alertException) {
            return false;
        }
        return true;
    }

    protected void leavePage() {
        if (isAlertPresent()) {
            alert.accept();
        }
    }

    protected void setConfirmHandlerToCancel(WebDriver driver) throws NoSuchFieldException, IllegalAccessException {
        if (driver instanceof FirefoxDriver) {
            handleAlert("cancel");
            return;
        }
        final Field webClientField = HtmlUnitDriver.class.getDeclaredField(FIELD_NAME_WEB_CLIENT);

        AccessController.doPrivileged(new PrivilegedAction<Object>() {

            public Object run() {
                webClientField.setAccessible(true);
                return null;
            }
        });

        ((WebClient) webClientField.get(driver)).setConfirmHandler(cancelHandler);
    }

    protected boolean isEditable(WebElement element) {
        try {
            if (element.getTagName().equalsIgnoreCase("select")) {
                new Select(element).getOptions();
            }
            if (element.getTagName().equalsIgnoreCase("input")) {
                element.clear();
            }
        } catch (InvalidElementStateException e1) {
            return false;
        }
        return true;
    }

    protected void waitForPageTitle(String title) {
        waitForPageTitle(title, DRIVER_WAIT_TIME);
    }

    protected void waitForPageTitle(String title, int timeOut) {
        Wait<WebDriver> wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.titleIs(title));
    }

    public boolean textToBePresentInURL(final String urlEndText, long milliseconds) {

        return new WebDriverWait(driver, milliseconds).until(new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver driver) {
                String text = driver.getCurrentUrl();
                return !text.endsWith(urlEndText);
            }
        });
    }

}