package Lesson6.pagesMyProject;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MessagesPage extends BaseView{

    public MessagesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "entered_name")
    public WebElement enteredName;

    public By nameLocator = By.id("entered_name");

    @Step("Заполнить поле Имя")
    public MessagesPage fillEntetredName(String name) {
        enteredName.sendKeys(name);
        return this;
    }

    @FindBy (id = "message_subject")
    public WebElement messageSubject;

    @Step("Заполнить поле Тема")
    public MessagesPage fillMessageSubject (String message) {
        messageSubject.sendKeys(message);
        return this;
    }

    @FindBy(name = "dosubmit")
    public WebElement submitMessage;

    @FindBy(xpath = "//h4[text()='Обнаружены следующие ошибки:']")
    public WebElement error;

    public By errorLocator = By.xpath("//h4[text()='Обнаружены следующие ошибки:']");

    @Step("Нажать на кнопку Отправить сообщение")
    public void sendMessage() {
        submitMessage.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator));
    }
}



