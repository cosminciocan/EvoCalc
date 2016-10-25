import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by evozon on 10/19/2016.
 */

@Test
public class NewTest {

    WebDriver driver = new FirefoxDriver();

    public void waitForElementIsVisible(By element) {
        int contor=0;
        do {
            try {
                Thread.sleep(200);
                contor+=200;
                System.out.println("Contor este: "+ contor);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (!driver.findElement(element).isDisplayed() && contor<=15000);
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
        search.sendKeys("bla bla bla");

        driver.quit();
    }

}
