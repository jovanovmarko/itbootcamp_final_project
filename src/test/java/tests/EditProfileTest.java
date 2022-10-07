package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EditProfileTest extends BaseTest {

    //Verify that displayed message contains "Profile saved successfully"
    //Verify that input fields have right value
    @Test
    public void editProfileTest() {
        String expectedResultMessage = "Profile saved successfuly";
        String expectedResultPhone = "tel";
        String expectedResultCity = "text";
        String expectedResultCountry = "text";
        String expectedResultTwitterUrl = "url";
        String expectedResultGitHubUrl = "url";
        homePage.clickLoginButton();
        homePage.clickSingUpButton();
        singUpPage.signup(faker.name().username(), faker.internet().emailAddress(), "12345", "12345");
        welcomePage.closeModalButtonWaiter();
        welcomePage.clickCloseModalButton();
        welcomePage.clickProfileButton();
        profilePage.editProfile(faker.phoneNumber().cellPhone(), faker.country().name(), "https://" + faker.internet().url(), "https://" + faker.internet().url());
        String actualResultMessage = profilePage.getMessage().getText();
        System.out.println(actualResultMessage);
        Assert.assertTrue(actualResultMessage.contains(expectedResultMessage));
        String actualResultPhone = profilePage.getPhoneField().getAttribute("type");
        String actualResultCity = profilePage.getCityField().getAttribute("type");
        String actualResultCountry = profilePage.getCountry().getAttribute("type");
        String actualResultTwitterUrl = profilePage.getTwitterUrl().getAttribute("type");
        String actualResultGitHubUrl = profilePage.getGitHubUrl().getAttribute("type");
        Assert.assertEquals(actualResultPhone, expectedResultPhone);
        Assert.assertEquals(actualResultCity, expectedResultCity);
        Assert.assertEquals(actualResultCountry, expectedResultCountry);
        Assert.assertEquals(actualResultTwitterUrl, expectedResultTwitterUrl);
        Assert.assertEquals(actualResultGitHubUrl, expectedResultGitHubUrl);

    }
}
