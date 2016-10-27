import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Raul-PC on 10/19/2016.
 */

@Test
public class iRaul {
    WebDriver driver = new FirefoxDriver();

    @Test
    public void loginPeEvoportal() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://evoportal.evozon.com");
        driver.manage().window().maximize();
        //driver.findElement(By.cssSelector())
        }


    @Test
    public void clickPeSearch() throws InterruptedException {
        List<WebElement> myList = driver.findElements(By.cssSelector(".main-menu li"));
        for (WebElement element : myList) {
            if (element.findElement(By.cssSelector("a span")).getText().contains("SEARCH")) {
                element.click();
            }
        }
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
    public void parcurgListaRezultate() throws InterruptedException {
        By searchField = By.cssSelector(".search-wrapper [name=_3_keywords]");
        waitForElements(searchField, 5000);

        driver.findElement(By.cssSelector("input[title=Search]")).click();
        WebElement container = driver.findElement(By.cssSelector("#_3_documentsSearchContainerSearchContainer"));
        List<WebElement> listaBenefits = container.findElements(By.cssSelector(".asset-entry-title>a"));
        for (WebElement element : listaBenefits) {
            if (element.getText().contains("Banca Comerciala Romana")) {
                element.click();
            }

        }
    }

}


