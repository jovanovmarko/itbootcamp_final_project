package tests;


import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;

import java.time.Duration;


public class LoginTest extends BaseTest {


    //Verify that url contains /login
    @Test
    public void urlLoginTest() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        homePage.getDriverWait().until(ExpectedConditions.visibilityOf(homePage.getLoginButtonHp()));
        homePage.clickLoginButton();
        String actualResult = homePage.getDriver().getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }

    //Verify that input fields have valid values
    @Test
    public void checkInputValueTest() {
        String expectedResultEmail = "email";
        String expectedResultPassword = "password";
        homePage.clickLoginButton();
        String actualResultEmail = loginPage.getEmailField().getAttribute("type");
        String actualResultPassword = loginPage.getPasswordField().getAttribute("type");
        Assert.assertEquals(expectedResultEmail, actualResultEmail);
        Assert.assertEquals(expectedResultPassword, actualResultPassword);
    }

    //Verify that error message "User does not exist" is displayed
    @Test
    public void errorUserMessage() {
        String expectedResultMessage = "User does not exists";
        homePage.clickLoginButton();
        String expectedResultUrl = "https://vue-demo.daniel-avellaneda.com/login";
        loginPage.login(faker.internet().emailAddress(), faker.internet().password());
        loginPage.waitPresenceErrorMessage();
        String actualResultMessage = loginPage.getErrorMessage().getText();
        Assert.assertTrue(actualResultMessage.contains(expectedResultMessage));
        String actualResultUrl = homePage.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedResultUrl, actualResultUrl);
    }

    //Verify that error message "Wrong password" is displayed
    @Test
    public void errorMessagePassword() {
        String expectedResultMessage = "Wrong password";
        homePage.clickLoginButton();
        String expectedResultUrl = "https://vue-demo.daniel-avellaneda.com/login";
        loginPage.login(" admin@admin.com", faker.internet().password());
        String actualResultMessage = loginPage.getErrorMessage().getText();
        Assert.assertTrue(actualResultMessage.contains(expectedResultMessage));
        String actualResultUrl = homePage.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedResultUrl, actualResultUrl);
    }

    //Verify that user can successfully login and that url contains /home
    @Test
    public void loginTest() {
        homePage.clickLoginButton();
        String expectedResultUrl = "https://vue-demo.daniel-avellaneda.com/home";
        loginPage.login("admin@admin.com", "12345");
        getDriverWait().until(ExpectedConditions.urlContains("/home"));
        String actualResultUrl = homePage.getDriver().getCurrentUrl();
        Assert.assertEquals(actualResultUrl, expectedResultUrl);
    }

    //Verify that user can successfully logout and that url contains /login
    @Test
    public void logoutTest() {
        homePage.clickLoginButton();
        String expectedResultUrl = "https://vue-demo.daniel-avellaneda.com/login";
        loginPage.login("admin@admin.com", "12345");
        welcomePage.logOutButtonWaiter();
        welcomePage.clickGetLogOutButtonWp();
        getDriverWait().until(ExpectedConditions.urlContains("/login"));
        String actualResultUrl = loginPage.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedResultUrl, actualResultUrl);
    }
}
