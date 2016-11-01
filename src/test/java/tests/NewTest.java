package tests;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BasePage;

import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

/**
 * Created by evozon on 10/19/2016.
 */

@Test
public class NewTest extends BasePage {


    @Test
    public void testMethod() throws InterruptedException {
        By searchInput = By.cssSelector(".search-wrapper input[name*='3_keywords']");
        driver.get("https://evoportal.evozon.com");

        driver.manage().window().maximize();
        WebElement searchLink = driver.findElement(By.linkText("SEARCH"));
        searchLink.click();

        waitForElement(searchInput, 5000);
        WebElement search = driver.findElement(searchInput);
        search.sendKeys("servicii");
        search.sendKeys(ENTER);

        By searchResults = By.cssSelector("span.asset-entry-title a");
        waitForElement(searchResults, 5000);
        List<WebElement> resultsList = driver.findElements(searchResults);
        System.out.println("Lista are " + resultsList.size() + " elemente");

        WebElement element = resultsList.get(randomGenerator(0, resultsList.size() - 1));
        String text = element.getText();
        element.click();

        By bodyContent = By.cssSelector("#main-content");
        waitForElement(bodyContent, 5000);
        WebElement bodyOfPage = driver.findElement(bodyContent);
        Assert.assertTrue(bodyOfPage.getText().contains(text));

    }


}

