import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.awt.windows.ThemeReader;

import java.util.List;
import java.util.Random;

import static org.openqa.selenium.Keys.ENTER;

/**
 * Created by evozon on 10/19/2016.
 */

@Test
public class NewTest {

    WebDriver driver = new FirefoxDriver();

    public void waitForElementIsVisible(By element) throws InterruptedException {
        boolean found = false;
        int contor = 0;
        do {
            try {
                found = driver.findElement(element).isDisplayed();

            } catch (NoSuchElementException e) {
                Thread.sleep(200);
                contor += 200;
            }
            if (contor >= 15000)
                Assert.fail("Element '" + element.toString() + "' not found");
        }
        while (!found);
    }

    @Test
    public void testMethod() throws InterruptedException {
        By searchInput = By.cssSelector(".search-wrapper input[name*='3_keywords']");
        driver.get("https://evoportal.evozon.com");

        driver.manage().window().maximize();
        WebElement searchLink = driver.findElement(By.linkText("SEARCH"));
        searchLink.click();

        waitForElementIsVisible(searchInput);
        WebElement search = driver.findElement(searchInput);
        search.sendKeys("servicii");
        search.sendKeys(ENTER);

        By searchResults = By.cssSelector("span.asset-entry-title a");
        waitForElementIsVisible(searchResults);
        List<WebElement> resultsList = driver.findElements(searchResults);
        System.out.println("Lista are " + resultsList.size() + " elemente");

        WebElement element = resultsList.get(randomInteger(0, resultsList.size()));
        String text = element.getText();
        element.click();

        By bodyContent = By.cssSelector("#main-content");
        waitForElementIsVisible(bodyContent);
        WebElement bodyOfPage = driver.findElement(bodyContent);
        Assert.assertTrue(bodyOfPage.getText().contains(text));

        driver.quit();
    }

    public int randomInteger ( int min, int max){
        Random rand = new Random();
        // nextInt excludes the top value so we have to add 1 to include the top value
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

}

