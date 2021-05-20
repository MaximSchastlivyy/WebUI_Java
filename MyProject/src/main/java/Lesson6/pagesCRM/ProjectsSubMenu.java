package Lesson6.pagesCRM;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectsSubMenu extends BaseView{
    public ProjectsSubMenu (WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Все проекты']")
    public WebElement allProjectsButton;

    @Step("Перейти на страницу проектов")
    public void createProject() {
        allProjectsButton.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(new ProjectsPage(driver).createProjectButtonLocator));
    }
}

