package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage  {

    private By loginButtonHp = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]");

    private By singUpButtonHp = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]");

    private By languageButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button");

    private By esLanguageButton = By.id("list-item-75");

    private By enLanguageButton = By.id("list-item-73");

    private By frLanguageButton = By.id("list-item-77");


    private By headerText = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1");





    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getLoginButtonHp() {
        return getDriver().findElement(loginButtonHp);
    }

    public WebElement getSingUpButtonHp() {
        return getDriver().findElement(singUpButtonHp);
    }

    public WebElement getLanguageButton() {
        return getDriver().findElement(languageButton);
    }

    public WebElement getEsLanguageButton() {
        return getDriver().findElement(esLanguageButton);
    }

    public WebElement getHeaderText() {
        return getDriver().findElement(headerText);
    }

    public WebElement getEnLanguageButton() {
        return getDriver().findElement(enLanguageButton);
    }

    public WebElement getFrLanguageButton() {
        return getDriver().findElement(frLanguageButton);
    }

    public void clickLoginButton() {
        getLoginButtonHp().click();
    }

    public void clickSingUpButton() {
        getSingUpButtonHp().click();
    }

    public void clickLanguageButton() {
        getLanguageButton().click();
    }

    public void clickEsLanguageButton() {
        getEsLanguageButton().click();
    }

    public void clickEnLanguageButton(){
        getEnLanguageButton().click();
    }

    public void clickFrLanguageButton(){
        getFrLanguageButton().click();
    }


    public void clickEsLanguageButtonWaiter() {
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(esLanguageButton));
    }

    public void clickEnLanguageButtonWaiter() {
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(enLanguageButton));
    }

    public void clickFrLanguageButtonWaiter() {
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(frLanguageButton));
    }

    public void headerTextWaiter(){
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(headerText));
    }
}
