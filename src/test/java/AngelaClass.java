import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.internal.FindsByLinkText;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by cosminciocan on 19/10/16.
 */
@Test
public class AngelaClass {
    WebDriver driver = new FirefoxDriver();
    By searchField = By.cssSelector(".search-wrapper [name=_3_keywords]");
    int defaultTimeoutValue = 5000;
    By searchButton = By.cssSelector(".search-wrapper [type=image]:not(#search)");
    List<WebElement> listOfResults = driver.findElements(By.cssSelector(".taglib-search-iterator"));

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
    public void newTest() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("http://evoportal.evozon.com");
        WebElement element = driver.findElement(By.linkText("SEARCH"));
        element.click();
        waitForElements(searchField, defaultTimeoutValue);
        driver.findElement(searchField).sendKeys("a");
        waitForElements(searchButton,defaultTimeoutValue);
        driver.findElement(searchButton).click();
        Thread.sleep(3000);
        int max = listOfResults.size()-1;
        int min = 0;
        Random generator = new Random();
        //By title = generator.nextInt(max-min

        driver.quit();
    }
}
