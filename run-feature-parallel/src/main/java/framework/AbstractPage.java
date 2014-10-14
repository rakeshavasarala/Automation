package framework;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public abstract class AbstractPage {

    private static final int DRIVER_WAIT_TIME = 60;
    //protected static final Logger LOG = LoggerFactory.getLogger(AbstractPage.class);
    public static final String ABOUT_BLANK = "about:blank";

    @Autowired
    private WebDriverDiscovery driver;

    @Value("${username}")
    public String defaultUserName;

    @Value("${password}")
    public String defaultPassWord;

    @Value("${plcUserName}")
    public String plcUserName;

    @Value("${plcPassword}")
    public String plcPassword;

    public WebDriver getDriver() {
        return driver.getRemoteWebDriver();
    }

    public WebElement findElement(By by) {
        return getDriver().findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return getDriver().findElements(by);
    }

    public WebElement findChildElement(WebElement element, final By by){
        Wait<WebElement> wait = new FluentWait<WebElement>(element)
                .withTimeout(DRIVER_WAIT_TIME, TimeUnit.SECONDS)
                .ignoring(ElementNotVisibleException.class)
                .ignoring(NoSuchElementException.class);

        return wait.until(new Function<WebElement, WebElement>() {
            @Override
            public WebElement apply(WebElement webElement) {
                return webElement.findElement(by);
            }
        });
    }

    public void navigate(String url) {
        getDriver().get(url);
    }

    public List<WebElement> waitForElementsVisible(final By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), DRIVER_WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        return getDriver().findElements(by);
    }

    public List<WebElement> waitForElementsClickable(final By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), DRIVER_WAIT_TIME);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        return getDriver().findElements(by);
    }

    public void refreshPage() {
        String currentURL = getDriver().getCurrentUrl();
        getDriver().navigate().to(currentURL);
        getDriver().navigate().refresh();
    }

    public WebElement waitForExpectedElement(final By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), DRIVER_WAIT_TIME);
        return wait.until(visibilityOfElementLocated(by));
    }

    public WebElement waitForExpectedElement(final By by, int timeout) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), timeout);
        return wait.until(visibilityOfElementLocated(by));
    }

    public void waitForElementPresent(final By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), DRIVER_WAIT_TIME);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForElementVisible(final By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), DRIVER_WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return getDriver().findElement(by);
    }

    public WebElement waitForElementVisible(final WebElement element, int timeOut) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), timeOut);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public void waitForTextPresent(final By by, String txt, int timeOut) {
        System.out.println("waiting for the text " + txt + " to be present... ");
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), timeOut);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(by, txt));
    }

    public WebElement waitForElementToBeClickableAndReturnElement(final By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), DRIVER_WAIT_TIME, 100);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        return getDriver().findElement(by);
    }

    public List<WebElement> waitForElementsToBeClickableAndReturnElement(final By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), DRIVER_WAIT_TIME, 100);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        return getDriver().findElements(by);
    }

    public WebElement waitForElementToBeClickable(final WebElement element) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), DRIVER_WAIT_TIME, 100);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }


    public WebElement waitForElementToBeClickable(final WebElement element, int timeout) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), timeout, 100);
        wait.until(ExpectedConditions.elementToBeSelected(element));
        return element;
    }


    public void waitForElementToBeClickable(final By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), DRIVER_WAIT_TIME, 100);
        wait.until(ExpectedConditions.elementToBeClickable(waitAndFindElement(by)));
    }

    public void waitForElementToDissappear(final By byLocator) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), DRIVER_WAIT_TIME, 100);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
    }

    public void waitForPageTitle(String title) {
        pageTitleWait(title, DRIVER_WAIT_TIME);
    }

    public void pageTitleWait(String title, int timeOut) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), timeOut);
        wait.until(ExpectedConditions.titleIs(title));
    }

    public Boolean isElementPresent(By by) {
        try {
            waitForElementPresent(by);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public Boolean isTextPresent(By by, String txt) {
        try {
            waitForTextPresent(by, txt, DRIVER_WAIT_TIME);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isElementDisplayed(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected ExpectedCondition<WebElement> visibilityOfElementLocated(final By by) {
        return new ExpectedCondition<WebElement>() {

            @Override
            public WebElement apply(WebDriver driver) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                WebElement element = getDriver().findElement(by);
                return element.isDisplayed() ? element : null;
            }
        };
    }

    public String getAlertDialogMsg() {
        Alert alert = getDriver().switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    public void acceptDialogIfAppears() {
        try {
            Alert alert = null;
            alert = getDriver().switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No Alert present");
        }
    }

    public void dismissDialogIfAppears() {
        Alert alert = getDriver().switchTo().alert();
        alert.dismiss();
    }

    // TODO - Made this CANCEL for Firefox
    public WebElement cancel() {
        return getDriver().findElement(By.linkText("CANCEL"));
    }

    public boolean isOnPage(String pageTitle) {
        return pageTitle.equalsIgnoreCase(getDriver().getTitle());
    }

    public void deleteAllCookies() {
        getDriver().manage().deleteAllCookies();
    }

    public void selectDropDown(WebElement element, String option) {
        Select s = new Select(element);
        s.selectByValue(option);
    }

    public void selectDropDownByVisibleText(WebElement element, String option) {
        Select s = new Select(element);
        s.selectByVisibleText(option);
    }

    public WebElement getElementByLinkText(String linkText) {
        return getDriver().findElement(By.linkText(linkText));
    }

    public WebElement waitAndFindElement(By by) {
        return waitForElementVisible(by);
    }

    public List<WebElement> waitAndFindElements(By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), DRIVER_WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(by)));
        return getDriver().findElements(by);
    }

    public void goTo(String url) {
        getDriver().get(url);
    }

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    public void maximizeWindow() {
        getDriver().manage().window().maximize();
    }

    public WebElement findElementByText(List<WebElement> eList, String text) {
        WebElement webElement = null;
        for (WebElement e : eList) {
            if (e.getText().equalsIgnoreCase(text)) {
                webElement = e;
                break;
            }
        }
        return webElement;
    }

    public WebElement findElementByAttribute(List<WebElement> eList, String attribute, String value) {
        WebElement webElement = null;
        for (WebElement e : eList) {
            if (e.getAttribute(attribute).trim().equalsIgnoreCase(value.trim())) {
                System.out.println("***************************** THE CONNECTOR, " + value.trim() + " HAS BEEN FOUND *****************************");
                webElement = e;
                break;
            }
        }
        return webElement;
    }

    public WebElement waitFluentForElement(final By by) {
        WebElement element = null;
        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return getDriver().findElement(by);
            }
        });
        return element;
    }

    public void switchToIframe(WebElement element) {
        getDriver().switchTo().frame(element);
    }

    public void switchOutFromIframe() {
        getDriver().switchTo().defaultContent();
    }

    public Boolean isTextPresent(By by, String txt, int timeInSeconds) {
        try {
            waitForTextPresent(by, txt, timeInSeconds);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

}