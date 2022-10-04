package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AdminCitiesTest extends BaseTest{

    @Test
    public void test1(){
        homePage.clickLoginButton();
        loginPage.login("admin@admin.com", "12345");
        welcomePage.clickAdminButton();




    }
}
