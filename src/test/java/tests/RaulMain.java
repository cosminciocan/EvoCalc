package tests;

import org.testng.annotations.Test;

/**
 * Created by Raul-PC on 10/27/2016.
 */

@Test
public class RaulMain {
    iRaul iRaul = new iRaul();

    @Test
    public void runProgram() throws InterruptedException{
        iRaul.loginPeEvoportal();
        iRaul.clickPeSearch();
        iRaul.parcurgListaRezultate();
    }
}
