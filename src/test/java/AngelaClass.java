import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created by cosminciocan on 19/10/16.
 */
@Test
public class AngelaClass {

    @Test
    public void newTest(){
        WebDriver driver = new FirefoxDriver();
        driver.get("http://evoportal.evozon.com");
        driver.findElement(By.cssSelector("#aui_3_4_0_1_164")).click();
        driver.quit();
    }
}
