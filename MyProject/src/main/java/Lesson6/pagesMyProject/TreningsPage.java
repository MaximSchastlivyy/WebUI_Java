package Lesson6.pagesMyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TreningsPage extends BaseView{
    public TreningsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Английский для тестировщиков']")
    public WebElement englishForTesters;

    public By englishForTestersLocator = By.xpath("//a[text()='Английский для тестировщиков']");

    public void goToEnglishTrening() {
        englishForTesters.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(new EnglishTreningPage(driver).signInLocator));
    }


}
