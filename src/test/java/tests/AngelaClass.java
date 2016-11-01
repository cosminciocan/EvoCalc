package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.internal.FindsByLinkText;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AngelaPage;
import utils.BasePage;
import utils.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by cosminciocan on 19/10/16.
 */
@Test
public class AngelaClass {

    AngelaPage angelaPage = new AngelaPage();

    @Test
    public void newTest() throws InterruptedException {
        angelaPage.getHomepage();
        angelaPage.clickSearch();
        angelaPage.searchForText("a");
        angelaPage.selectRandomElementFromList();
    }
}
