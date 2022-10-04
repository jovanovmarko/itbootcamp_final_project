package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage  {

    private By loginButtonHp = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]");

    private By singUpButtonHp = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]");




    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getLoginButtonHp() {
        return getDriver().findElement(loginButtonHp);
    }

    public WebElement getSingUpButtonHp() {
        return getDriver().findElement(singUpButtonHp);
    }

    public void clickLoginButton() {
        getLoginButtonHp().click();
    }

    public void clickSingUpButton() {
        getSingUpButtonHp().click();
    }
}
