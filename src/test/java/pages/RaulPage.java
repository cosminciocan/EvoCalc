package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.BasePage;

import java.util.List;

/**
 * Created by Raul-PC on 11/1/2016.
 */
public class RaulPage extends BasePage {

    public void loginPeEvoportal()  {
        driver.get("https://evoportal.evozon.com");
        driver.manage().window().maximize();
        //driver.findElement(By.cssSelector())
    }

    public void clickPeSearch() {
        List<WebElement> myList = driver.findElements(By.cssSelector(".main-menu li"));
        for (WebElement element : myList) {
            if (element.findElement(By.cssSelector("a span")).getText().contains("SEARCH")) {
                element.click();
            }
        }
    }


    public void parcurgListaRezultate() {
        By searchField = By.cssSelector(".search-wrapper [name=_3_keywords]");
        waitForElement(searchField, 5000);
        driver.findElement(By.cssSelector(".search-wrapper [name=_3_keywords]")).sendKeys("benefits");
        driver.findElement(By.cssSelector("input[title=Search]")).click();
    }

    public void alegeRezultatRandom() {
        WebElement container = driver.findElement(By.cssSelector("#_3_documentsSearchContainerSearchContainer"));
        List<WebElement> listaBenefits = container.findElements(By.cssSelector(".asset-entry-title>a"));
        int valoareaRandom = randomGenerator(0,listaBenefits.size());
         WebElement randomClick = listaBenefits.get(valoareaRandom);
         String selectedElementText = randomClick.getText();
         randomClick.click();
         sleep(5000);


             Assert.assertTrue(selectedElementText.contains(selectedElementText));

     }

       // for (WebElement element : listaBenefits) {
         //   if (element.getText().contains("Banca Comerciala Romana")) {
           //     element.click();
           // }

        //}




}
