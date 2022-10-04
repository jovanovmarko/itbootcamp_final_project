package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SingUpTest extends BaseTest {

    @Test
    public void singUpTest1() {
        String expectedResultUrl = "https://vue-demo.daniel-avellaneda.com/signup";
        homePage.clickSingUpButton();
        getDriverWait().until(ExpectedConditions.urlContains("/signup"));
        String actualResultUrl = getDriver().getCurrentUrl();
        Assert.assertEquals(expectedResultUrl,actualResultUrl);
    }

    @Test
    public void singUpTest2() {
        homePage.clickSingUpButton();
        String actualResultEmail = singUpPage.getEmailField().getAttribute("type");
        String actualResultPassword = singUpPage.getPasswordField().getAttribute("type");
        String actualResultConfirmPassword = singUpPage.getConfirmPasswordField().getAttribute("type");
        String expectedResultEmail = "email";
        String expectedResultPassword = "password";
        String expectedResultConfirmPassword = "password";
        Assert.assertEquals(actualResultEmail,expectedResultEmail);
        Assert.assertEquals(actualResultPassword,expectedResultPassword);
        Assert.assertEquals(actualResultConfirmPassword,expectedResultConfirmPassword);

    }

    @Test
    public void singUpTest3() {
        homePage.clickSingUpButton();
        String expectedResult = "E-mail already exists";
        singUpPage.signup("test test","admin@admin.com","123654","123654");
        String actualResult = singUpPage.getemailAlreadyExistMessage().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void singUpTest4() {
        homePage.clickSingUpButton();
        String expectedResult = "IMPORTANT: Verify your account";
        singUpPage.signup("John Doe", "john.doe99@itbootcamp.rs","123456","123456");
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
        }
        String actualResult = welcomePage.getVerifyAccMsg().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }






}
