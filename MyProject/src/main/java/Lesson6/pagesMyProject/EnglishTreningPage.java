package Lesson6.pagesMyProject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EnglishTreningPage extends BaseView{
    public EnglishTreningPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Записаться']")
    public WebElement signIn;

    public By signInLocator = By.xpath("//a[text()='Записаться']");

    @Step("Перейти на страницу регистрации на тренинг")
    public void goToSignInForEnglishTrening() {
        signIn.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(new SignInForEnglishTreningPage(driver).signInForEnglishTreningTitleLocator));
    }
}
