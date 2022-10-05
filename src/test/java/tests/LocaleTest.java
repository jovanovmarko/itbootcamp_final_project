package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTest extends BaseTest {

    @Test
    public void test1() {
        String expectedResult = "Página de aterrizaje";
        homePage.clickLanguageButton();
        homePage.clickEsLanguageButtonWaiter();
        homePage.clickEsLanguageButton();
        homePage.headerTextWaiter();
        String actualResult = homePage.getHeaderText().getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void test2() {
        String expectedResult = "Landing";
        homePage.clickLanguageButton();
        homePage.clickEnLanguageButtonWaiter();
        homePage.clickEnLanguageButton();
        homePage.headerTextWaiter();
        String actualResult = homePage.getHeaderText().getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void test3() {
        String expectedResult = "Page d'atterrissage";
        homePage.clickLanguageButton();
        homePage.clickFrLanguageButtonWaiter();
        homePage.clickFrLanguageButton();
        homePage.headerTextWaiter();
        String actualResult = homePage.getHeaderText().getText();
        Assert.assertEquals(actualResult,expectedResult);
    }


}
