import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

/**
 * Created by evozon on 10/19/2016.
 */

@Test
public class NewTest {

    WebDriver driver = new FirefoxDriver();

    public void waitForElementIsVisible(By element) throws InterruptedException {
        boolean found = false;
        int contor=0;
        do{
            try {
                found = driver.findElement(element).isDisplayed();

            } catch (NoSuchElementException e) {
                Thread.sleep(200);
                contor += 200;
            }
            if (contor >= 15000)
                Assert.fail("Element '" + element.toString() + "' not found");
        }
        while(!found);
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

        List<WebElement> resultsList = driver.findElements(By.cssSelector("span.asset-entry-title"));
        System.out.println("Lista are " + resultsList.size() + " elemente");


        
//        for (WebElement element: resultsList){
//            System.out.println("Elementele din lista: " + element);
//            //Assert.assertTrue(element.getText().contains("kiuuiubuji"));
//        }
        //Thread.sleep(5000);

        driver.quit();
    }

}
