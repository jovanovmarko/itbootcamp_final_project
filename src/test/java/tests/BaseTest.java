package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;

public abstract class BaseTest {

    private String baseUrl = "https://vue-demo.daniel-avellaneda.com";

    protected WebDriver driver;

    protected WebDriverWait driverWait;

    protected LoginPage loginPage;

    protected HomePage homePage;

    protected WelcomePage welcomePage;

    protected SingUpPage singUpPage;

    protected CitiesPage citiesPage;

    protected ProfilePage profilePage;

    protected Faker faker;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        loginPage = new LoginPage(driver,driverWait);
        homePage = new HomePage(driver,driverWait);
        welcomePage = new WelcomePage(driver,driverWait);
        singUpPage = new SingUpPage(driver,driverWait);
        citiesPage = new CitiesPage(driver,driverWait);
        profilePage = new ProfilePage(driver,driverWait);
        faker = new Faker();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void quit() {
        driver.quit();

    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl);
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait getDriverWait() {
        return driverWait;
    }

    public void setDriverWait(WebDriverWait driverWait) {
        this.driverWait = driverWait;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(LoginPage loginPage) {
        this.loginPage = loginPage;
    }
}
