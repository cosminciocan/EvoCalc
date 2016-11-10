package tests;

import org.testng.annotations.Test;
import pages.RaulPage;

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
        raulPage.alegeRezultatRandom();

    }



}


