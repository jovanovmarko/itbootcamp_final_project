package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTest extends BaseTest {

    //Verify that header language is changed
    @Test
    public void setLocaleToEsTest() {
        String expectedResult = "Página de aterrizaje";
        homePage.clickLanguageButton();
        homePage.clickEsLanguageButtonWaiter();
        homePage.clickEsLanguageButton();
        homePage.headerTextWaiter();
        String actualResult = homePage.getHeaderText().getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    //Verify that header language is changed
    @Test
    public void setLocaleToEnTest() {
        String expectedResult = "Landing";
        homePage.clickLanguageButton();
        homePage.clickEnLanguageButtonWaiter();
        homePage.clickEnLanguageButton();
        homePage.headerTextWaiter();
        String actualResult = homePage.getHeaderText().getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    //Verify that header language is changed
    @Test
    public void setLocaleToFrTest() {
        String expectedResult = "Page d'atterrissage";
        homePage.clickLanguageButton();
        homePage.clickFrLanguageButtonWaiter();
        homePage.clickFrLanguageButton();
        homePage.headerTextWaiter();
        String actualResult = homePage.getHeaderText().getText();
        Assert.assertEquals(actualResult,expectedResult);
    }


}
