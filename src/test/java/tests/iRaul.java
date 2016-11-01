package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RaulPage;

import java.util.List;

import static utils.BasePage.driver;

/**
 * Created by Raul-PC on 10/19/2016.
 */

@Test
public class iRaul {

    RaulPage raulPage = new RaulPage();

    @Test
    public void allRaulTests()  {
        driver.manage().window().maximize();
        raulPage.loginPeEvoportal();
        raulPage.clickPeSearch();
        raulPage.parcurgListaRezultate();


    }



}


