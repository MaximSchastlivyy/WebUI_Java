package Lesson6;

import Lesson6.pagesMyProject.LoginPage;
import Lesson6.pagesMyProject.MainPage;
import Lesson7.CustomLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static Lesson6.Configuration.BASE_URL_MY_PROJECT;

public class BaseTestsMyProject {
    EventFiringWebDriver driver;
    WebDriverWait webDriverWait;
    MainPage mainPage;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupBrowser() {
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new CustomLogger());
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
        List<LogEntry> logs = driver.manage().logs().get(LogType.BROWSER).getAll();
        if (logs.size() > 0) {
            driver.manage().logs().get(LogType.BROWSER).getAll().forEach(System.out::println);
        } else driver.quit();

        driver.quit();
    }
}


