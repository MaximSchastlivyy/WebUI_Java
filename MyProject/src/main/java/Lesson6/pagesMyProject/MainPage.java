package Lesson6.pagesMyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BaseView{

    @FindBy(id = "sign_in")
    public WebElement signIn;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void setSignIn() {
        signIn.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(new LoginPage(driver).loginLocator));
    }

    @FindBy(xpath = "//a[text()='Выход']")
    public WebElement exitButton;

    public By exitButtonLocator = By.xpath("//a[text()='Выход']");

    @FindBy(xpath = "//a[text()='Тренинги']")
    public WebElement trenings;

    public void goToTrenings() {
        trenings.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(new TreningsPage(driver).englishForTestersLocator));
    }

    @FindBy(id = "main_search")
    public WebElement mainSearch;

    @FindBy(className = "submit_input")
    public WebElement submitSearch;

    @FindBy(id = "inbox_link")
    public WebElement inboxLink;

    public By inboxLinkLocator = By.id("inbox_link");

    @FindBy(xpath = "//a[text()='Написать личное сообщение']")
    public WebElement writeMessage;

    public By writeMessageLocator = By.xpath("//a[text()='Написать личное сообщение']");

    public void searchInformation (String info) {
        mainSearch.sendKeys(info);
        submitSearch.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(new SearchResultPage(driver).searchResultLocator));
    }

    public void sendMessage () {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(inboxLinkLocator));
        inboxLink.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(writeMessageLocator));
        writeMessage.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(new MessagesPage(driver).nameLocator));
    }
}
