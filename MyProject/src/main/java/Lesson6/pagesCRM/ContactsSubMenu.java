package Lesson6.pagesCRM;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactsSubMenu extends BaseView{
    public ContactsSubMenu (WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Контактные лица']")
    public WebElement contactsButton;

    @Step("Перейти на страницу контактов")
    public void createContact() {
        contactsButton.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(new ContactsPage(driver).createContactButtonLocator));
    }
}
