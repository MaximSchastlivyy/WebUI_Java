package Lesson6.pagesCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectsPage extends BaseView{
    public ProjectsPage (WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Создать проект']")
    public WebElement createProjectButton;

    public void createProject() {
        createProjectButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(new ProjectCreatePage(driver).nameLocator));
    }

    public By createProjectButtonLocator = By.xpath("//a[text()='Создать проект']");
}


