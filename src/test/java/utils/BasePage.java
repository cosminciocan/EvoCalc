package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import java.util.Random;

/**
 * Created by cosminciocan on 28/10/16.
 */
public class BasePage extends Driver{

    public void waitForElements(By element, int timeoutMilliseconds) {
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

    public int randomGenerator(int max,int min){
        Random generator = new Random();
        return generator.nextInt((max-min)+1)+min;
    }



}
