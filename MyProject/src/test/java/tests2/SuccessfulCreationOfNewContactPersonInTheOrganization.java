package tests2;

/**
 Успешное создание нового контактного лица на сайте https://crm.geekbrains.space/user/login

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
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SuccessfulCreationOfNewContactPersonInTheOrganization {
    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        login();

        Actions actions = new Actions(driver);
        WebElement contragents = driver.findElement(By.xpath("//div[@id='main-menu']//*[text()='Контрагенты']"));
        actions.moveToElement(contragents).perform();

        driver.findElement(By.xpath("//div[@id='main-menu']//*[text()='Контактные лица']")).click();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[text()='Создать контактное лицо']")).click();

        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Тестов");
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Тест");

        driver.findElement(By.xpath("//span[text()='Укажите организацию']/..")).click();
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys("Тестовая организация 7");
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys(Keys.ENTER);

        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("Директор");

        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Контактное лицо сохранено']")));
        driver.findElement(By.xpath("//*[text()='Контактное лицо сохранено']"));

        Thread.sleep(5000);

        driver.quit();
    }

    private static void login() {
        driver.get(LOGIN_PAGE_URL);
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}
