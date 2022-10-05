package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest {

    @Test
    public void test1() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        getDriver().get("https://vue-demo.daniel-avellaneda.com/home");
        String actualResult = getDriver().getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }



    @Test
    public void test2() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        getDriver().get("https://vue-demo.daniel-avellaneda.com/profile");
        String actualResult = getDriver().getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void test3() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        getDriver().get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        String actualResult = getDriver().getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void test4() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        getDriver().get("https://vue-demo.daniel-avellaneda.com/admin/users");
        String actualResult = getDriver().getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }


}
