package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Moka on 10/19/2016.
 */
@Test
public class ATestClass extends Thread {
    WebDriver driver = new FirefoxDriver();
    By searchField = By.cssSelector(".search-wrapper [name=_3_keywords]");
    int defaultTimeoutValue = 5000;

    WebElement container = driver.findElement(By.cssSelector("table > tbody"));

    List <WebElement> titles = container.findElements(By.cssSelector(".asset-entry-title > a "));
//    for (WebElement element : titles)
    int nr = randomWithRange(1, titles.size());
   // titles(nr).click().


    int randomWithRange(int min, int max)
    {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

    public void waitForElements(By element, int timeoutMilliseconds) throws InterruptedException {
        int x = 0;
        boolean found = false;

        while (!found) {
            try {
                found = driver.findElement(element).isDisplayed();

            } catch (NoSuchElementException e) {
                Thread.sleep(200);
                x += 200;
            }
            if (x >= timeoutMilliseconds)
                Assert.fail("Element '" + element.toString() + "' not found");

        }

    }

    @Test
    public void openEvoportal() throws InterruptedException {
//        WebDriver driver = new FirefoxDriver();
        driver.get("http://evoportal.evozon.com");
        driver.findElement(By.cssSelector(".main-menu li:nth-child(8)")).click();
        //waitForElement(driver.findElement(By.cssSelector(".main-menu li:nth-child(8)")).click());
//        WebElement element=driver.findElement(By.cssSelector(".focus)"));

        By element = By.cssSelector(".main-menu li:nth-child(8)");
        waitForElements(element, defaultTimeoutValue);
        driver.findElement(By.cssSelector("input[type='text']:nth-child(9)")).sendKeys("template");
        driver.findElement(By.cssSelector("input[type='image']:nth-child(11)")).click();
        titles.get(nr).click();

        // waitForElement(driver.findElement(By.cssSelector(".main-menu li:nth-child(8)")).click(););
    }
}

