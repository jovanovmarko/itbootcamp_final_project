package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingUpPage extends BasePage {


    private By nameField = By.id("name");

    private By emailField = By.id("email");

    private By passWordField = By.id("password");

    private By confirmPasswordField = By.id("confirmPassword");

    private By singMeUpButton = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button");

    private By emailAlreadyExistMessage = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]");

    public SingUpPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getNameField() {
        return getDriver().findElement(nameField);
    }

    public WebElement getEmailField() {
        return getDriver().findElement(emailField);
    }

    public WebElement getPasswordField() {
        return getDriver().findElement(passWordField);
    }

    public WebElement getConfirmPasswordField() {
        return getDriver().findElement(confirmPasswordField);
    }

    public WebElement getSingMeUpButton() {
        return getDriver().findElement(singMeUpButton);
    }

    public WebElement getEmailAlreadyExistMessage() {
        return getDriver().findElement(emailAlreadyExistMessage);
    }

    public void signup(String name, String email, String password, String confirmPassword) {
        getNameField().clear();
        getEmailField().clear();
        getPasswordField().clear();
        getConfirmPasswordField().clear();
        getNameField().sendKeys(name);
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getConfirmPasswordField().sendKeys(confirmPassword);
        getSingMeUpButton().click();

    }

    public void singUpWaiter() {
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(nameField));
    }
}
