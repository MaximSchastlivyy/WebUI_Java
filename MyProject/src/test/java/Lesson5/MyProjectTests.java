package Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class MyProjectTests {

    WebDriver driver;
    WebDriverWait webDriverWait;
    private static final String BASE_URL = "https://software-testing.ru/forum/";

    @BeforeSuite
    void setupDataBase() {
        System.out.println("Before suite setup database");
    }

    @BeforeTest
    void setUp() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeMethod
    void setUpBrowser() {
        driver = new FirefoxDriver();
        webDriverWait = new WebDriverWait(driver, 15);
        driver.get(BASE_URL);
        login();
    }

    @Test(description = "Успешная авторизауия на сайте https://software-testing.ru/forum/", enabled = true)
    void authorizationTest() throws InterruptedException {
        assertThat(driver.findElement(By.xpath("//a[text()='Выход']")), isDisplayed());
    }

    @Test(description = "Успешный поиск на сайте https://software-testing.ru/forum/", enabled = true)
    void searchTest() throws InterruptedException {
        driver.findElement(By.id("main_search")).sendKeys("Начинающему тестировщику");
        driver.findElement(By.className("submit_input")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//em/strong[text()='начинающему тестировщику']")));
        assertThat(driver.findElement(By.xpath("//em/strong[text()='начинающему тестировщику']")), isDisplayed());
    }

    @Test(description = "Отправка личного сообщения несуществующему контакту на сайте https://software-testing.ru/forum/", enabled = true)
    void sendMessageToUnknownContactTest() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("inbox_link")));
        driver.findElement(By.id("inbox_link")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Написать личное сообщение']")));
        driver.findElement(By.xpath("//a[text()='Написать личное сообщение']")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("entered_name")));
        driver.findElement(By.id("entered_name")).sendKeys("Тест");
        driver.findElement(By.id("message_subject")).sendKeys("Тестовая тема");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
        driver.findElement(By.xpath("//body")).sendKeys("Тестирование сообщений");
        driver.switchTo().defaultContent();
        driver.findElement(By.name("dosubmit")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Необходимо вручную ввести полное имя пользователя, либо выбрать его из вашего списка контактов.']")));
        assertThat(driver.findElement(By.xpath("//p[text()='Необходимо вручную ввести полное имя пользователя, либо выбрать его из вашего списка контактов.']")), isDisplayed());
    }

    @Test(description = "Переход на страницу записи на тренинг \"Английский для тестировщиков\" на сайте https://software-testing.ru/forum/",
            enabled = true)
    void registrationForTreningTest() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Тренинги']")));
        driver.findElement(By.xpath("//a[text()='Тренинги']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Английский для тестировщиков']")));
        driver.findElement(By.xpath("//a[text()='Английский для тестировщиков']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Записаться']")));
        driver.findElement(By.xpath("//a[text()='Записаться']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Регистрация на тренинг \"Английский для тестировщиков\"']")));
        assertThat(driver.findElement(By.xpath("//h2[text()='Регистрация на тренинг \"Английский для тестировщиков\"']")), isDisplayed());
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }

    private void login() {
        driver.findElement(By.id("sign_in")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("ips_username")));
        driver.findElement(By.id("ips_username")).sendKeys("SchastlivyMax");
        driver.findElement(By.id("ips_password")).sendKeys("12345678");
        driver.findElement(By.className("ipsButton")).click();
    }
}

/**
 1. Успешная авторизауия на сайте https://software-testing.ru/forum/

 1. Зайти на сайт https://software-testing.ru/forum/, используя логин "SchastlivyMax", пароль "12345678".
 ОР: Успешная авторизация на сайте, вход выполнен, есть кнопка "Выход".


 2. Успешный поиск по сайту https://software-testing.ru/forum/

 1. Зайти на сайт https://software-testing.ru/forum/, используя логин "SchastlivyMax", пароль "12345678".
 ОР: Успешная авторизация на сайте, вход выполнен, есть кнопка "Выход".
 2. Ввести в поле "Поиск" данные, например "Начинающему тестировщику"
 ОР: Данные успешно вводятся в поле "Поиск"
 3. Нажать Enter
 ОР: Поиск по введенным данным выполнен, есть текст "Результаты поиска"

 3. Отправка личного сообщения несуществующему контакту на сайте https://software-testing.ru/forum/

 1. Зайти на сайт https://software-testing.ru/forum/, используя логин "SchastlivyMax", пароль "12345678".
 ОР: Успешная авторизация на сайте, вход выполнен, есть кнопка "Выход".
 2. Нажать на кнопку "Личные сообщения"
 ОР: Появляется окно сообщений
 3. Нажать на кнопку "Написать личное сообщение"
 ОР: Происходит переход на страницу для отправки личного сообщения.
 4. Ввести в поле Имя получателя "Тест", в поле Тема сообщения "Тестовая тема", в поле текста самого сообщения "Тестирование сообщений"
 ОР: Все данные введены, кнопка "Отправить сообщение" активна.
 5. Нажать на кнопку "Отправить сообщение"
 ОР: Появляется ошибка с текстом "Необходимо вручную ввести полное имя пользователя, либо выбрать его из вашего списка контактов."


 4. Переход на страницу записи на тренинг на сайте https://software-testing.ru/forum/

 1. Зайти на сайт https://software-testing.ru/forum/, используя логин "SchastlivyMax", пароль "12345678".
 ОР: Успешная авторизация на сайте, вход выполнен, есть кнопка "Выход".
 2. Нажать на кнопку "Тренинги"
 ОР: Происходит переход на страницу с доступными тренингами
 3. Нажать на название тренинга "Английский для тестировщиков"
 ОР: Происходит переход на страницу тренинга "Английский для тестировщиков"
 4. Нажать на кнопку "Записаться"
 ОР: Происходит переход на форму для записи на тренинг

 */

