package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTest extends BaseTest {

    //Verify that current url contains /admins/cities
    @Test
    public void urlCityTest() {
        String expectedResultUrl = "https://vue-demo.daniel-avellaneda.com/admin/cities";
        homePage.clickLoginButton();
        loginPage.login("admin@admin.com", "12345");
        welcomePage.clickAdminButton();
        welcomePage.citiesButtonWaiter();
        welcomePage.clickCitiesButton();
        getDriverWait().until(ExpectedConditions.urlContains("/admin/cities"));
        String actualResultUrl = welcomePage.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedResultUrl, actualResultUrl);
        Assert.assertTrue(welcomePage.getLogOutButtonWp().isDisplayed());
    }

    //Verify that user can successfully create new city
    @Test
    public void createNewCityTest() {
        homePage.clickLoginButton();
        String expectedResult = "Saved successfully";
        loginPage.login("admin@admin.com", "12345");
        welcomePage.clickAdminButton();
        welcomePage.citiesButtonWaiter();
        welcomePage.clickCitiesButton();
        citiesPage.newCityCreate("MJCity");
        citiesPage.getSaveSuccessfullyMsgWaiter();
        String actualResult = citiesPage.getSaveSuccessfullyMsg().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

    }

    //Verify that user can successfully can edit previously created city
    @Test
    public void editCityTest() {
        homePage.clickLoginButton();
        String expectedResult = "Saved successfully";
        loginPage.login("admin@admin.com", "12345");
        welcomePage.clickAdminButton();
        welcomePage.citiesButtonWaiter();
        welcomePage.clickCitiesButton();
        citiesPage.editCity("Edited");
        citiesPage.getSaveSuccessfullyMsgWaiter();
        String actualResult = citiesPage.getSaveSuccessfullyMsg().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    //Verify that searched city is displayed in table below
    @Test
    public void searchCityTest() {
        homePage.clickLoginButton();
        String expectedResult = "MJCity";
        loginPage.login("admin@admin.com", "12345");
        welcomePage.clickAdminButton();
        welcomePage.citiesButtonWaiter();
        welcomePage.clickCitiesButton();
        citiesPage.searchCity("MJCity");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
        citiesPage.getSearchedCityNameWaiter();
        String actualResult = citiesPage.getSearchedCityName().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    //Verify that user can successfully delete previously created city
    @Test
    public void deleteCityTest() {
        homePage.clickLoginButton();
        String expectedResult = "MJCity";
        String expectedResultMsg = "Deleted successfully";
        loginPage.login("admin@admin.com", "12345");
        welcomePage.clickAdminButton();
        welcomePage.citiesButtonWaiter();
        welcomePage.clickCitiesButton();
        citiesPage.searchCity("MJCity");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        citiesPage.getSearchedCityNameWaiter();
        String actualResult = citiesPage.getSearchedCityName().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
        citiesPage.deleteCity();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        String actualResultMsg = citiesPage.getDeleteMessage().getText();
        Assert.assertTrue(actualResultMsg.contains(expectedResultMsg));
    }


}
