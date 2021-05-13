package Lesson6.pagesMyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BaseView{

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[text()='Результаты поиска']")
    public WebElement searchResult;

    public By searchResultLocator = By.xpath("//h1[text()='Результаты поиска']");
}