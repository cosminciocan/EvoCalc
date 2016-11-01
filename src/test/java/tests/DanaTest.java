package tests;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DanaPage;
import utils.BasePage;

import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

/**
 * Created by evozon on 10/19/2016.
 */

@Test
public class DanaTest extends BasePage {


    @Test
    public void testMethod() {
        DanaPage danaPage = new DanaPage();

        danaPage.getHomepage();
        danaPage.clickOnSearchLink();
        danaPage.searchForSomething("servicii");
        danaPage.selectRandomElementFromList();

    }


}

