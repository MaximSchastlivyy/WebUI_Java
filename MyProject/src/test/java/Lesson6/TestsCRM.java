package Lesson6;

import Lesson6.pagesCRM.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class TestsCRM extends BaseTestsCRM {

    @Test
    @DisplayName("Успешное создание нового контактного лица на сайте https://crm.geekbrains.space/")
    void createNewContact() {

        new NavigationMenu(driver).openNavigationMenuItem("Контрагенты");

        new ContactsSubMenu(driver).createContact();
        new ContactsPage(driver).createContact();

        new ContactCreatePage(driver)
                .fillLastName("Тестов")
                .fillFirstName("Тест")
                .setOrganization("Тестовая организация 7")
                .fillJobTitle("Директор")
                .saveAndCloseButton.click();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(new ContactCreatePage(driver).creationOfNewContactLocator)));

        assertThat(new ContactCreatePage(driver).creationOfNewContact, isDisplayed());
    }

    @Test
    @DisplayName("Успешное создание нового проекта на сайте https://crm.geekbrains.space/")
    void createNewProject() {

        new NavigationMenu(driver).openNavigationMenuItem("Проекты");

        new ProjectsSubMenu(driver).createProject();
        new ProjectsPage(driver).createProject();

        new ProjectCreatePage(driver)
                .fillName("Тестовый проект 1234567")
                .setOrganization("Тестовая организация 7")
                .setContact()
                .selectBusinessUnit("Research & Development")
                .selectCurator("Applanatest1 Applanatest1 Applanatest1")
                .selectRp("Applanatest1 Applanatest1 Applanatest1")
                .selectAdministrator("Applanatest1 Applanatest1 Applanatest1")
                .selectManager("Applanatest1 Applanatest1 Applanatest1")
                .saveAndCloseButton.click();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(new ProjectCreatePage(driver).creationOfNewProjectLocator)));

        assertThat(new ProjectCreatePage(driver).creationOfNewProject, isDisplayed());
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