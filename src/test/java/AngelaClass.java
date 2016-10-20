import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.internal.FindsByLinkText;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by cosminciocan on 19/10/16.
 */
@Test
public class AngelaClass {

    @Test
    public void newTest(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://evoportal.evozon.com");
        WebElement element = driver.findElement(By.linkText("SEARCH"));
        element.click();
        WebElement element1 = driver.findElement(By.cssSelector(".search-wrapper [name=_3_keywords]"));
        element1.sendKeys("abcv");
        driver.quit();
    }
}
