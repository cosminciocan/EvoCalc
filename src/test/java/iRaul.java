import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created by Raul-PC on 10/19/2016.
 */

@Test
public class iRaul {

    @Test
    public void loginPeEvoportal() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://evoportal.evozon.com");
        driver.findElement(By.cssSelector("#aui_3_4_0_1_140")).click();
        driver.findElement(By.name("_3_keywords")).sendKeys("Paula");
       // driver.findElement(By.cssSelector("#"))
        driver.quit();


    }

}
