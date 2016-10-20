import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created by evozon on 10/19/2016.
 */

@Test
public class NewTest {

    public void testMethod() throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://evoportal.evozon.com");
//        WebElement signInBtn = driver.findElement(By.id("sign-in"));
//        signInBtn.click();
//        WebElement userInput = driver.findElement((By.className("aui-field-input aui-field-input-text aui-form-validator-error")));
//        WebElement passInput = driver.findElement((By.id("_58_password")));
//        WebElement submitBtn = driver.findElement((By.className("aui-button-input aui-button-input-submit")));
//        userInput.sendKeys("danazhr");
//        passInput.sendKeys("bla bla");
//        submitBtn.click();
        driver.manage().window().maximize();
        WebElement libraryLink = driver.findElement(By.linkText("SEARCH"));
        libraryLink.click();
//        WebElement search = driver.findElement(By.cssSelector("form > input[type='text']"));
        Thread.sleep(15000);
        WebElement search = driver.findElement(By.cssSelector(".search-wrapper input[name*='3_keywords']"));
        search.sendKeys("bla bla bla");

        driver.quit();
    }

}
