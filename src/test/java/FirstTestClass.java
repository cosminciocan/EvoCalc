import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.security.Key;

@Test
public class FirstTestClass {

    @Test
    public void firstTest(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://emag.ro");
        driver.findElement(By.id("emg-input-autosuggest")).sendKeys("Ceva aici!");
        driver.findElement(By.id("emg-input-autosuggest")).sendKeys(Keys.ENTER);
        driver.quit();


    }

}
