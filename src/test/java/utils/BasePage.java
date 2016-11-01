package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Random;

/**
 * Created by cosminciocan on 28/10/16.
 */
public class BasePage extends Driver{

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

            } catch (NoSuchElementException e) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                x += 200;
            }
            if (x >= timeoutMilliseconds)
                Assert.fail("Element '" + element.toString() + "' not found");

        }

    }

    public int randomGenerator(int min,int max){
        Random generator = new Random();
        System.out.println("This is max" + max);
        System.out.println("This is min" + min);
        return generator.nextInt((max-min)+1)+min;
    }



}
