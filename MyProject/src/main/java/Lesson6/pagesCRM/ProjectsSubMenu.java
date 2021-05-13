package Lesson6.pagesCRM;

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

    public void createProject() {
        allProjectsButton.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(new ProjectsPage(driver).createProjectButtonLocator));
    }
}

