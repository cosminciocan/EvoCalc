package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Random;

/**
 * Created by cosminciocan on 28/10/16.
 */
public class BasePage extends Driver {

    public static WebDriver driver;


    static {
        startSuite();
    }

    private static void startSuite() {
        try {
            Driver.initWebDriver();
            driver = Driver.getWebdriver();
        } catch (Exception e) {
            System.out.println("Exception when start suite:\n" + e);
        }
    }

    public void waitForElement(By element, int timeoutMilliseconds) {
        int x = 0;
        boolean found = false;

        while (!found) {
            try {
                found = driver.findElement(element).isDisplayed();

            } catch (Exception e) {
                sleep(200);
                x += 200;
            }
            if (x >= timeoutMilliseconds)
                Assert.fail("Element '" + element.toString() + "' not found");
        }
    }

    public int randomGenerator(int min, int max) {
        Random generator = new Random();
        return generator.nextInt((max - min) + 1) + min;
    }

    public void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.err.println("Error: " + e);
        }

    }

    public void waitForElementNotPresent(By elementLocator, int timoutMilliseconds) {
        boolean isDisplayed = true;
        int x = 0;
        while (isDisplayed) {
            try {
                driver.findElement(elementLocator).isDisplayed();
                sleep(200);
                x += 200;
            } catch (Exception e) {
                isDisplayed = false;
            }
            if (x >= timoutMilliseconds)
                Assert.fail("Timed out waiting for element to disappear!");

        }
    }
}
