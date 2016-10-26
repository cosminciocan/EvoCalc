import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created by Moka on 10/19/2016.
 */
@Test
public class ATestClass extends Thread {
    @Test
    public void openEvoportal() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://evoportal.evozon.com");
        driver.findElement(By.cssSelector(".main-menu li:nth-child(8)")).click();
        //waitForElement(driver.findElement(By.cssSelector(".main-menu li:nth-child(8)")).click());
        WebElement element=driver.findElement(By.cssSelector(".focus)"));
        waitForElement(element);
        driver.findElement(By.cssSelector("input[type='text']:nth-child(9)")).sendKeys("template");
        driver.findElement(By.cssSelector("input[type='image']:nth-child(11)")).click();

        // waitForElement(driver.findElement(By.cssSelector(".main-menu li:nth-child(8)")).click(););
    }


    public void waitForElement(WebElement element) throws InterruptedException {
        while (!element.isDisplayed()) {
            //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Thread.sleep(400);
        }
    }

//        }
//        driver.quit();
}

