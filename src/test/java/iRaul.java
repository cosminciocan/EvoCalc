import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Raul-PC on 10/19/2016.
 */

@Test
public class iRaul {

    @Test
    public void loginPeEvoportal() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://evoportal.evozon.com");
        driver.manage().window().maximize();
        List<WebElement> myList = driver.findElements(By.cssSelector(".main-menu li"));
            for (WebElement element : myList){
                if (element.findElement(By.cssSelector("a span")).getText().contains("SEARCH")) {
                    element.click();
                }
            }
            Thread.sleep(15000);

        //driver.findElement(By.cssSelector("#aui_3_4_0_1_140")).click();

        driver.findElement(By.cssSelector("input[name=_3_keywords]")).sendKeys("benefits");
        driver.quit();


    }

}
