package uk.co.automation.setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BrowserFacade {

    private static WebDriver driver;

    private static void initialiseDriver(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors","--allow-insecure-localhost");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    public static WebElement waitForElementToClickable(final By selector) {
        return waiting(5).until(ExpectedConditions.elementToBeClickable(selector));
    }
    public static Wait<WebDriver> waiting(int duration) {
        return new FluentWait<WebDriver>(driver).withTimeout(duration, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
    }

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                close();
            }
        });
    }

    private static void close() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Throwable ignored) {
            }
        }
    }

    public static void initialize(boolean deleteCookie) {

        if (driver == null) {
            initialiseDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        if (deleteCookie) {
            clearCookies();
        }
    }
    public static void clearCookies() {
        driver.manage().deleteAllCookies();
    }
    public static WebDriver getDriver() {
        return driver;
    }

    public static void clickOnElementWithHref(String href) {
        BrowserFacade.click(By.xpath("//a[@href='"  + href + "' ]"));
    }

    public static void click(final By by) {
        waitForElementToClickable(by);
        driver.findElement(by).click();
    }

    public static WebElement getElement(By by) {
        return driver.findElement(by);
    }

    public static WebElement waitForElementToAppear(final By selector) {
        return waiting(5).until(ExpectedConditions.visibilityOfElementLocated(selector));
    }
}
