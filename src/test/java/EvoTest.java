import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Ema on 10/19/2016.
 **/

@Test
public class EvoTest {

    @Test
    public void searchEvoPortal(){
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://evoportal.evozon.com");
        webDriver.manage().window().maximize();
        List<WebElement> myList = webDriver.findElements(By.cssSelector("#aui_3_4_0_1_176 li"));

        for(WebElement element : myList)
            if(element.findElement(By.cssSelector("a span")).getText().contains("SEARCH"))
                element.click();

        //webDriver.wait(5000);
        webDriver.findElement(By.cssSelector("input[name*=_3_keywords]")).sendKeys("benefits");

        webDriver.quit();

        }




    }

