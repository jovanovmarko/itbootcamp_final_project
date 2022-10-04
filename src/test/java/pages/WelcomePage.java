package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WelcomePage extends BasePage {

    private By logOutButtonWp = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]");

    private By verifyAccMsg = By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]");

    private By adminButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]");

    private By citiesButton = By.xpath("//*[@id=\"list-item-214\"]/div[2]");





    public WelcomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getLogOutButtonWp() {
        return getDriver().findElement(logOutButtonWp);
    }

    public WebElement getVerifyAccMsg() {
        return getDriver().findElement(verifyAccMsg);
    }

    public WebElement getAdminButton() {
        return getDriver().findElement(adminButton);
    }

    public WebElement getCitiesButton() {
        return getDriver().findElement(citiesButton);
    }




    public void clickGetLogOutButtonWp() {
        getLogOutButtonWp().click();
    }

    public void clickAdminButton() {
        getAdminButton().click();
    }

    public void clickCitiesButton() {
        getCitiesButton().click();
    }



    public void logOutButtonWaiter() {
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(logOutButtonWp));
    }

    public void verifyAccMsgWaiter() {
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(verifyAccMsg));
    }

}
