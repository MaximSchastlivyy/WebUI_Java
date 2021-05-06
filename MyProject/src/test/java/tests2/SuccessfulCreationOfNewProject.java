package tests2;

/**
Успешное создание нового проекта на сайте https://crm.geekbrains.space/user/login

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

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SuccessfulCreationOfNewProject {

    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        login();

        Actions actions = new Actions(driver);
        WebElement projectMenuItem = driver.findElement(By.xpath("//span[text()='Проекты']/ancestor::a"));
        actions.moveToElement(projectMenuItem).perform();

        driver.findElement(By.xpath("//li[@data-route='crm_project_my']/a")).click();

        driver.findElement(By.xpath("//a[text()='Создать проект']")).click();

        driver.findElement(By.name("crm_project[name]")).sendKeys("Тестовый проект 11111");
        driver.findElement(By.xpath("//span[text()='Укажите организацию']/..")).click();
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys("Тестовая организация 7");
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys(Keys.ENTER);

        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[contains(@id,'s2id_crm_project_contactMain')]/a")).click();
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

        Thread.sleep(5000);

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Проект сохранен']")));
        driver.findElement(By.xpath("//*[text()='Проект сохранен']"));

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
