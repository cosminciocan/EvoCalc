package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * Created by cosminciocan on 28/10/16.
 */
public class Driver {

    private static WebDriver driver;

    public static void initWebDriver(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();



        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                System.out.println("Closing browser");
                driver.quit();
            }
        });
    }

    public static WebDriver getWebdriver() {
        if (driver == null)
            initWebDriver();
        return driver;
    }

}
