import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created by Moka on 10/19/2016.
 */
@Test
public class ATestClass {
    @Test
    public void openEvoportal() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://evoportal.evozon.com");
        driver.findElement(By.cssSelector(".main-menu li:nth-child(8)")).click();
        driver.findElement(By.cssSelector("input[type='text']:nth-child(9)")).sendKeys("template");
        driver.quit();
    }
}
