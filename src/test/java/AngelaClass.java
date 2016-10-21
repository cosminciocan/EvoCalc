import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.internal.FindsByLinkText;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by cosminciocan on 19/10/16.
 */
@Test
public class AngelaClass {

    @Test
    public void newTest() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://evoportal.evozon.com");
        WebElement element = driver.findElement(By.linkText("SEARCH"));
        element.click();
        int x = 0;

        while (!driver.findElement(By.cssSelector(".search-wrapper [name=_3_keywords]")).isDisplayed()) {
            Thread.sleep(200);
            if ( x >= 5000)
                break;

            x+=200;
        }


        driver.findElement(By.cssSelector(".search-wrapper [name=_3_keywords]")).sendKeys("abcv");
        Thread.sleep(3000);

        driver.quit();
    }
}
