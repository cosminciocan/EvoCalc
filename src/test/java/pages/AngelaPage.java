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
    By itemPerPageDropDown = By.cssSelector(".aui-form > .aui-paginator-container .aui-field-input-menu");
    By articleList = By.cssSelector(".taglib-search-iterator .results-row:not(.lfr-template)");
    By dropdownOptions = By.cssSelector(".aui-form > .aui-paginator-container .aui-field-input-menu [value]");
    By dropdownValues = By.id("_evozonlibrary_WAR_EvozonLibraryportlet_ocerSearchContainerPageIterator_itemsPerPage");

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

    public void clickLibrary() {
        waitForElement(libraryLink, defaultTimeoutValue);
        driver.findElement(libraryLink).click();
    }

    public void selectItemPerPage() {

        waitForElement(dropdownValues, defaultTimeoutValue);
        Select dropdownValue = new Select(driver.findElement(dropdownValues));
        dropdownValue.selectByVisibleText("30");

        waitForElementNotPresent(By.cssSelector(".aui-loadingmask:not(.aui-helper-hidden) .aui-loadingmask-message-content"),5000);

        waitForElement(articleList, defaultTimeoutValue);
        List<WebElement> listOfItems = driver.findElements(articleList);
        System.out.println("Lista" + listOfItems.size());
        Assert.assertTrue((listOfItems.size() + "").equals("30"));



        List<WebElement> listDropdownOptions = driver.findElements(dropdownOptions);
        System.out.println("elemente drowpdown" + listDropdownOptions.size());
        int x = randomGenerator(0, listDropdownOptions.size() - 1);
        dropdownValue.selectByIndex(x);
        waitForElement(articleList, defaultTimeoutValue);
        System.out.println("Lista" + listOfItems.size());
        Assert.assertTrue(listOfItems.size() == x);


    }


}

