package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.BasePage;

import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

/**
 * Created by evozon on 11/1/2016.
 */
public class DanaPage extends BasePage {
    By searchInput = By.cssSelector(".search-wrapper input[name*='3_keywords']");
    By searchLink = By.linkText("SEARCH");
    By searchResults = By.cssSelector("span.asset-entry-title a");
    By bodyContent = By.cssSelector("#main-content");
    By libraryLink = By.linkText("LIBRARY");
    By selectItemsPerPage = By.cssSelector("#_evozonlibrary_WAR_EvozonLibraryportlet_ocerSearchContainerPageIterator_itemsPerPage option");
    By tableContainer = By.cssSelector(".results-row:not(.lfr-template)");
    By loadingSpinner = By.cssSelector(".aui-loadingmask:not(.aui-helper-hidden) .aui-loadingmask-message-content");


    public void getHomepage() {
        driver.get("http://evoportal.evozon.com");
    }

    public void clickOnSearchLink() {
        driver.findElement(searchLink).click();
    }

    public void searchForSomething(String text) {
        waitForElement(searchInput, 5000);
        driver.findElement(searchInput).sendKeys(text);
        driver.findElement(searchInput).sendKeys(ENTER);
    }

    public void selectRandomElementFromList() {
        waitForElement(searchResults, 5000);
        List<WebElement> resultsList = driver.findElements(searchResults);
        //System.out.println("Lista are " + resultsList.size() + " elemente");
        WebElement element = resultsList.get(randomGenerator(0, (resultsList.size() - 1)));
        String text = element.getText();
        element.click();
        waitForElement(bodyContent, 5000);
        WebElement bodyOfPage = driver.findElement(bodyContent);
        Assert.assertTrue(bodyOfPage.getText().contains(text));
    }

    public void clickOnLibraryLink() {
        driver.findElement(libraryLink).click();
    }

    public void selectItemsNumberPerPage() {
        waitForElement(selectItemsPerPage, 5000);
        List<WebElement> dropdownValues = driver.findElements(selectItemsPerPage);
        WebElement valueFromDropdown = dropdownValues.get(randomGenerator(0, (dropdownValues.size() - 1)));
        String selectedValue = valueFromDropdown.getText();
        valueFromDropdown.click();

        waitForElementNotPresent(loadingSpinner, 5000);

        waitForElement(tableContainer, 5000);
        List<WebElement> tableRows = driver.findElements(tableContainer);
        String rowsNumber = tableRows.size() + "";
        Assert.assertEquals(rowsNumber, selectedValue);

    }
}
