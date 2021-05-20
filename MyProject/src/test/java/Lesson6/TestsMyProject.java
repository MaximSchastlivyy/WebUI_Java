package Lesson6;

import Lesson6.pagesMyProject.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class TestsMyProject extends BaseTestsMyProject{
    @Test
    @DisplayName("Успешная авторизация на сайте https://software-testing.ru/forum/")
    void authorizationTest() {
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(new MainPage(driver).exitButtonLocator));
        assertThat(new MainPage(driver).exitButton, isDisplayed());
    }

    @Test
    @DisplayName("Успешный поиск на сайте https://software-testing.ru/forum/")
    void searchTest() {
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(new MainPage(driver).exitButtonLocator));
        new MainPage(driver).searchInformation("Начинающему тестировщику");
        assertThat(new SearchResultPage(driver).searchResult, isDisplayed());
    }

    @Test
    @DisplayName("Отправка личного сообщения несуществующему контакту на сайте https://software-testing.ru/forum/")
    void sendMessageNegativeTest() {
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(new MainPage(driver).exitButtonLocator));
        new MainPage(driver).sendMessage();
        new MessagesPage(driver)
                .fillEntetredName("Тест")
                .fillMessageSubject("Тестовая тема")
                .submitMessage.click();
        webDriverWait.until(
                ExpectedConditions.visibilityOfElementLocated(new MessagesPage(driver).errorLocator));

        assertThat(new MessagesPage(driver).error, isDisplayed());
    }

    @Test
    @DisplayName("Переход на страницу записи на тренинг \\\"Английский для тестировщиков\\\" на сайте https://software-testing.ru/forum/\"")
    void registrationForTreningTest() {
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(new MainPage(driver).exitButtonLocator));
        new MainPage(driver).goToTrenings();
        new TreningsPage(driver).goToEnglishTrening();
        new EnglishTreningPage(driver).goToSignInForEnglishTrening();

        assertThat(new SignInForEnglishTreningPage(driver).signInForEnglishTreningTitle, isDisplayed());
    }
}


