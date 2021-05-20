package Lesson6.pagesMyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInForEnglishTreningPage extends BaseView{
    public SignInForEnglishTreningPage (WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[text()='Регистрация на тренинг \"Английский для тестировщиков\"']")
    public WebElement signInForEnglishTreningTitle;

    public By signInForEnglishTreningTitleLocator = By.xpath("//h2[text()='Регистрация на тренинг \"Английский для тестировщиков\"']");

}
