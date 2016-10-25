import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.internal.FindsByLinkText;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by cosminciocan on 19/10/16.
 */
@Test
public class AngelaClass {
    WebDriver driver = new FirefoxDriver();
    By searchField = By.cssSelector(".search-wrapper [name=_3_keywords]");

    @Test
    public void waitForElements(By element) throws InterruptedException {
        int x = 0;
        boolean found = false;

        while (!found) {
            try {
                found = driver.findElement(element).isDisplayed();

            } catch (NoSuchElementException e) {
                Thread.sleep(200);
                x += 200;
            }
            if (x >= 5000)
                Assert.fail("Element '" + element.toString() + "' not found");

        }

    }

    @Test
    public void newTest() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("http://evoportal.evozon.com");
        WebElement element = driver.findElement(By.linkText("SEARCH"));
        element.click();
        waitForElements(By.cssSelector(".cevaClasaCareNuExista"));

        driver.findElement(searchField).sendKeys("abcv");
        Thread.sleep(2000);
        driver.quit();
    }
}
