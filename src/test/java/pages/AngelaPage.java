package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.BasePage;

import java.util.List;


/**
 * Created by cosminciocan on 28/10/16.
 */
public class AngelaPage extends BasePage {

    By searchField = By.cssSelector(".search-wrapper [name=_3_keywords]");
    int defaultTimeoutValue = 5000;
    By searchButton = By.cssSelector(".search-wrapper [type=image]:not(#search)");
    By headerTitle = By.cssSelector(".header-title");
    By titleList = By.cssSelector(".asset-entry-title a");
    By searchLink = By.linkText("SEARCH");

    By libraryLink = By.linkText("LIBRARY");
    By itemPerPageDropDown = By.cssSelector(".aui-field-input.aui-field-input-select.aui-field-input-menu");

    public void getHomepage() {
        driver.get("http://evoportal.evozon.com");
    }

    public void clickSearch() {
        driver.findElement(searchLink).click();
    }

    public void searchForText(String text) {
        waitForElement(searchField, defaultTimeoutValue);
        driver.findElement(searchField).sendKeys(text);
        waitForElement(searchButton, defaultTimeoutValue);
        driver.findElement(searchButton).click();
    }

    public void selectRandomElementFromList() {
        List<WebElement> listOfResults = driver.findElements(titleList);
        int x = randomGenerator(0, listOfResults.size() - 1);
        String articleTitle = listOfResults.get(x).getText();
        listOfResults.get(x).click();
        waitForElement(headerTitle, defaultTimeoutValue);
        Assert.assertTrue(driver.findElement(headerTitle).getText().contains(articleTitle));
    }
    public void clickLibrary (){
    driver.findElement(libraryLink).click();
    }
    public void selectItemPerPage (){
        Select as = new Select(driver.findElement(By.cssSelector("")));
    }
}

