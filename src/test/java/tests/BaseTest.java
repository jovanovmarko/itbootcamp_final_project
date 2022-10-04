package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {

    private String baseUrl = "https://vue-demo.daniel-avellaneda.com";

    private WebDriver driver;

    private WebDriverWait driverWait;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl);
    }
}
