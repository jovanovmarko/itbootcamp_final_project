package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {

    private By nameField = By.id("name");

    private By phoneField = By.id("phone");

    private By cityField = By.id("city");

    private By newCity = By.xpath("//*[@id=\"list-item-166-1\"]");

    private By country = By.id("country");

    private By twitterUrl = By.id("urlTwitter");

    private By gitHubUrl = By.id("urlGitHub");

    private By saveButton = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button");

    private By message = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]");


    public ProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getNameField() {
        return getDriver().findElement(nameField);
    }

    public WebElement getPhoneField() {
        return getDriver().findElement(phoneField);
    }

    public WebElement getCityField() {
        return getDriver().findElement(cityField);
    }

    public WebElement getNewCity() {
        return getDriver().findElement(newCity);
    }

    public WebElement getCountry() {
        return getDriver().findElement(country);
    }

    public WebElement getTwitterUrl() {
        return getDriver().findElement(twitterUrl);
    }

    public WebElement getGitHubUrl() {
        return getDriver().findElement(gitHubUrl);
    }


    public WebElement getSaveButton() {
        return getDriver().findElement(saveButton);
    }

    public WebElement getMessage() {
        return getDriver().findElement(message);
    }


    public void editProfile(String phone, String country, String twitterUrl, String gitHubUrl) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        getPhoneField().sendKeys(phone);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        getCityField().click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {

        }
        getNewCity().click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        getCountry().sendKeys(country);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        getTwitterUrl().sendKeys(twitterUrl);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        getGitHubUrl().sendKeys(gitHubUrl);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        getSaveButton().click();
    }


}
