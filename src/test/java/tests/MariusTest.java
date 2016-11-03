package tests;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MariusPage;
import utils.BasePage;

import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

/**
 * Created by evozon on 10/19/2016.
 */

@Test
public class MariusTest extends BasePage {

    MariusPage mariusPage = new MariusPage();


    @Test
    public void testMethod() {
        mariusPage.getHomepage();
        mariusPage.clickOnSearchLink();
        mariusPage.searchForSomething("servicii");
        mariusPage.selectRandomElementFromList();


    }

    @Test
    public void libraryTest(){
        mariusPage.getHomepage();
        mariusPage.clickOnLibraryLink();
        mariusPage.selectItemsNumberPerPage();
    }


}

