import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created by Ema on 10/19/2016.
 **/

@Test
public class EvoTest {

    @Test
    public void searchEvoPortal(){
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://evoportal.evozon.com");
        webDriver.findElement(By.cssSelector(".main-menu li:nth-child(8)")).click();


    }





}
