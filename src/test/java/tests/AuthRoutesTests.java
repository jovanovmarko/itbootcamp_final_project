package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest {

    //Verify that when user is not logged in website will redirect to /login page
    @Test
    public void forbidVisitToHomeTest() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        getDriver().get("https://vue-demo.daniel-avellaneda.com/home");
        String actualResult = getDriver().getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }


    //Verify that when user is not logged in website will redirect to /login page
    @Test
    public void forbidVisitToProfileTest() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        getDriver().get("https://vue-demo.daniel-avellaneda.com/profile");
        String actualResult = getDriver().getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }

    //Verify that when user is not logged in website will redirect to /login page
    @Test
    public void forbidVisitToAdminCitiesTest() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        getDriver().get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        String actualResult = getDriver().getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }

    //Verify that when user is not logged in website will redirect to /login page
    @Test
    public void forbidVisitToAdminUsersTest() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        getDriver().get("https://vue-demo.daniel-avellaneda.com/admin/users");
        String actualResult = getDriver().getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }


}
