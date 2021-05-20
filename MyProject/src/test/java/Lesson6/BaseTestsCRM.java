package Lesson6;

import Lesson6.pagesCRM.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static Lesson6.Configuration.BASE_URL_CRM;

public class BaseTestsCRM {
    WebDriver driver;
    WebDriverWait webDriverWait;
    LoginPage loginPage;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        loginPage = new LoginPage(driver);
    }

    @BeforeEach
    public void login() {
        driver.get(BASE_URL_CRM);
        new LoginPage(driver)
                    .fillInputLogin("Applanatest1")
                    .fillInputPassword("Student2020!")
                    .submitLogin();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
