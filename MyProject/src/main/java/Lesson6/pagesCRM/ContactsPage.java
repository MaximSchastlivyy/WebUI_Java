package Lesson6.pagesCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactsPage extends BaseView{
    public ContactsPage (WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Создать контактное лицо']")
    public WebElement createContactButton;

    public void createContact() {
        createContactButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(new ContactCreatePage(driver).lastNameLocator));
    }

    public By createContactButtonLocator = By.xpath("//a[text()='Создать контактное лицо']");
}