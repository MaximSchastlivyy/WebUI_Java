package tests1;

/**
Успешный поиск по сайту https://software-testing.ru/forum/

1. Зайти на сайт https://software-testing.ru/forum/, используя логин "SchastlivyMax", пароль "12345678".
ОР: Успешная авторизация на сайте, вход выполнен, есть кнопка "Выход".
2. Ввести в поле "Поиск" данные, например "Начинающему тестировщику"
ОР: Данные успешно вводятся в поле "Поиск"
3. Нажать Enter
ОР: Поиск по введенным данным выполнен, есть текст "Результаты поиска"
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SuccesfulSearch {

    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://software-testing.ru/forum/");
        driver.findElement(By.id("sign_in")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("ips_username")).sendKeys("SchastlivyMax");
        driver.findElement(By.id("ips_password")).sendKeys("12345678");
        driver.findElement(By.className("ipsButton")).click();
        driver.findElement(By.id("main_search")).sendKeys("Начинающему тестировщику");
        driver.findElement(By.className("submit_input")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//em/strong[text()='начинающему тестировщику']"));

        Thread.sleep(3000);

        driver.quit();
    }
}

