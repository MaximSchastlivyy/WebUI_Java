package Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class CRMTests {

    WebDriver driver;
    WebDriverWait webDriverWait;
    private static final String BASE_URL = "https://crm.geekbrains.space/user/login";

    @BeforeSuite
    void setupDataBase() {
        System.out.println("Before suite setup database");
    }

    @BeforeTest
    void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void setUpBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 15);
        driver.get(BASE_URL);
        login();
    }

    @Test(description = "Успешное создание нового контактного лица на сайте https://crm.geekbrains.space/user/login", enabled = true)
    void newContactCreationTest() throws InterruptedException {

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@id='main-menu']//*[text()='Контрагенты']")))
                .build()
                .perform();

        driver.findElement(By.xpath("//div[@id='main-menu']//*[text()='Контактные лица']")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Создать контактное лицо']")));
        driver.findElement(By.xpath("//a[text()='Создать контактное лицо']")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name("crm_contact[lastName]")));
        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Тестов");
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Тест");
        driver.findElement(By.xpath("//span[text()='Укажите организацию']/..")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='select2-input select2-focused']")));
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys("Тестовая организация 7");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='select2-input select2-focused']")));
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys(Keys.ENTER);
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("Директор");
        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Контактное лицо сохранено']")));
        assertThat(driver.findElement(By.xpath("//*[text()='Контактное лицо сохранено']")), isDisplayed());
    }

    @Test(description = "Успешное создание нового проекта на сайте https://crm.geekbrains.space/user/login", enabled = true)
    void newProjectCreationTest() throws InterruptedException {

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//span[text()='Проекты']/ancestor::a")))
                .build()
                .perform();

        driver.findElement(By.xpath("//li[@data-route='crm_project_my']/a")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Создать проект']")));
        driver.findElement(By.xpath("//a[text()='Создать проект']")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name("crm_project[name]")));
        driver.findElement(By.name("crm_project[name]")).sendKeys("Тестовый проект 222222");
        driver.findElement(By.xpath("//span[text()='Укажите организацию']/..")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='select2-input select2-focused']")));
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys("Тестовая организация 7");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='select2-input select2-focused']")));
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys(Keys.ENTER);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@id,'s2id_crm_project_contactMain')]/a")));
        driver.findElement(By.xpath("//div[contains(@id,'s2id_crm_project_contactMain')]/a")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name=\"crm_project[contactMain]\"]/option[3]")));
        driver.findElement(By.xpath("//select[@name=\"crm_project[contactMain]\"]/option[3]")).click();
        driver.findElement(By.xpath("//input[@name='crm_project[type]' and contains(@data-name, 'field__1')]")).click();

        Select businessUnit = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        businessUnit.selectByVisibleText("Research & Development");
        Select curator = new Select(driver.findElement(By.name("crm_project[curator]")));
        curator.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");
        Select rp = new Select(driver.findElement(By.name("crm_project[rp]")));
        rp.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");
        Select administrator = new Select(driver.findElement(By.name("crm_project[administrator]")));
        administrator.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");
        Select manager = new Select(driver.findElement(By.name("crm_project[manager]")));
        manager.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");

        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Проект сохранен']")));
        assertThat(driver.findElement(By.xpath("//*[text()='Проект сохранен']")), isDisplayed());
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }

    private void login() {
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}

/**
 1. Успешное создание нового контактного лица на сайте https://crm.geekbrains.space/user/login

 1. Авторизоваться на сайте https://crm.geekbrains.space/user/login, используя следующие данные: Логин/пароль: Applanatest/Student2020!
 ОР: Пользователь успешно авторизовался, видит страницу «Панель инструментов».
 2. Перейти в «Контрагенты» → «Контактные лица»
 ОР: Пользователь находится на странице «Контактные лица», видит таблицу имеющихся контактных лиц, есть кнопка «Создать контактное лицо».
 3. Нажать на кнопку «Создать контактное лицо»
 ОР: Открыта страница создания контактного лица.
 4. Заполнить обязательные поля: фамилия; имя; организация; должность.
 ОР: Поля заполнены.
 5. Нажать на кнопку «Сохранить и закрыть»
 ОР: Страница создания контактного лица закрыта, пользователь видит страницу «Все контактные лица» и всплывающее уведомление «Контактное лицо сохранено».


 2. Успешное создание нового проекта на сайте https://crm.geekbrains.space/user/login

 1. Авторизоваться на сайте https://crm.geekbrains.space/user/login, используя следующие данные: Логин/пароль: Applanatest/Student2020!
 ОР: Пользователь успешно авторизовался, видит страницу «Панель инструментов».
 2. Перейти в «Проекты» → «Мои проекты»
 ОР: Пользователь находится на странице «Мои проекты», присутствует кнопка «Создать проект».
 3. Нажать на кнопку «Создать проект»
 ОР: Открыта страница создания проекта.
 4. Заполнить обязательные поля: наименование; организация; основное контактное лицо; подразделение; куратор проекта; руководитель проекта; администратор проекта; менеджер.
 ОР: Поля заполнены.
 5. Нажать на кнопку «Сохранить и закрыть»
 ОР: Страница создания проекта закрыта. Пользователь видит страницу «Все проекты» и всплывающее уведомление о том, что проект успешно создан.

 */