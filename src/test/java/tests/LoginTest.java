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


    @Test
    public void loginTest1() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        homePage.getDriverWait().until(ExpectedConditions.visibilityOf(homePage.getLoginButtonHp()));
        homePage.clickLoginButton();
        String actualResult = homePage.getDriver().getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void loginTest2() {
        String expectedResultEmail = "email";
        String expectedResultPassword = "password";
        homePage.clickLoginButton();
        String actualResultEmail = loginPage.getEmailField().getAttribute("type");
        String actualResultPassword = loginPage.getPasswordField().getAttribute("type");
        Assert.assertEquals(expectedResultEmail, actualResultEmail);
        Assert.assertEquals(expectedResultPassword, actualResultPassword);
    }

    @Test
    public void loginTest3() {
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

    @Test
    public void loginTest4() {
        String expectedResultMessage = "Wrong password";
        homePage.clickLoginButton();
        String expectedResultUrl = "https://vue-demo.daniel-avellaneda.com/login";
        loginPage.login(" admin@admin.com", faker.internet().password());
        String actualResultMessage = loginPage.getErrorMessage().getText();
        Assert.assertTrue(actualResultMessage.contains(expectedResultMessage));
        String actualResultUrl = homePage.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedResultUrl, actualResultUrl);
    }

    @Test
    public void loginTest5() {
        homePage.clickLoginButton();
        String expectedResultUrl = "https://vue-demo.daniel-avellaneda.com/home";
        loginPage.login("admin@admin.com", "12345");
        getDriverWait().until(ExpectedConditions.urlContains("/home"));
        String actualResultUrl = homePage.getDriver().getCurrentUrl();
        Assert.assertEquals(actualResultUrl, expectedResultUrl);
    }

    @Test
    public void loginTest6() {
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
