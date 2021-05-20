package Lesson6;

import Lesson6.pagesMyProject.LoginPage;
import Lesson6.pagesMyProject.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Lesson6.Configuration.BASE_URL_MY_PROJECT;

public class BaseTestsMyProject {
    WebDriver driver;
    WebDriverWait webDriverWait;
    MainPage mainPage;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    public void setupBrowser() {
        driver = new FirefoxDriver();
        webDriverWait = new WebDriverWait(driver, 30);
    }

    @BeforeEach
    public void login() {
        driver.get(BASE_URL_MY_PROJECT);
        new MainPage(driver).setSignIn();
        new LoginPage(driver)
                .fillLogin("SchastlivyMax")
                .fillPassword("12345678")
                .submitLogin();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}


