package Lesson6.pagesCRM;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ProjectCreatePage extends BaseView{
    public ProjectCreatePage (WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "crm_project[name]")
    public WebElement name;

    @Step("Заполнить поле Имя")
    public ProjectCreatePage fillName(String newName) {
        name.sendKeys(newName);
        return this;
    }

    public By nameLocator = By.name("crm_project[name]");

    @FindBy(xpath = "//span[text()='Укажите организацию']/..")
    public WebElement organization;

    @FindBy(xpath = "//input[@class='select2-input select2-focused']")
    public WebElement selectedOrganization;

    public By selectedOrganizationLocator = By.xpath("//input[@class='select2-input select2-focused']");

    @Step("Установить организацию")
    public ProjectCreatePage setOrganization(String org) {
        organization.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selectedOrganizationLocator));
        selectedOrganization.sendKeys(org);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selectedOrganizationLocator));
        selectedOrganization.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(xpath = "//div[contains(@id,'s2id_crm_project_contactMain')]/a")
    public WebElement contact;

    public By contactLocator = By.xpath("//div[contains(@id,'s2id_crm_project_contactMain')]/a");

    @FindBy(xpath = "//select[@name=\"crm_project[contactMain]\"]/option[3]")
    public WebElement selectedContact;

    public By selectedContactLocator = By.xpath("//select[@name=\"crm_project[contactMain]\"]/option[3]");

    @FindBy(xpath = "//input[@name='crm_project[type]' and contains(@data-name, 'field__1')]")
    public WebElement contactForProject;

    @Step("Установить контактное лицо")
    public ProjectCreatePage setContact () {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(contactLocator));
        contact.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selectedContactLocator));
        selectedContact.click();
        contactForProject.click();
        return this;
    }

    @FindBy(name = "crm_project[businessUnit]")
    public WebElement businessUnit;

    @Step("Выбрать подразделение")
    public ProjectCreatePage selectBusinessUnit(String unit) {
        new Select(businessUnit).selectByVisibleText(unit);
        return this;
    }

    @FindBy(name = "crm_project[curator]")
    public WebElement curator;

    @Step("Выбрать куратора проекта")
    public ProjectCreatePage selectCurator(String cur) {
        new Select(curator).selectByVisibleText(cur);
        return this;
    }

    @FindBy(name = "crm_project[rp]")
    public WebElement rp;

    @Step("Выбрать руководителя проекта")
    public ProjectCreatePage selectRp(String r) {
        new Select(rp).selectByVisibleText(r);
        return this;
    }

    @FindBy(name = "crm_project[administrator]")
    public WebElement administrator;

    @Step("Выбрать администратора проекта")
    public ProjectCreatePage selectAdministrator(String adm) {
        new Select(administrator).selectByVisibleText(adm);
        return this;
    }

    @FindBy(name = "crm_project[manager]")
    public WebElement manager;

    @Step("Выбрать менеджера проекта")
    public ProjectCreatePage selectManager(String man) {
        new Select(manager).selectByVisibleText(man);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Сохранить и закрыть')]")
    public WebElement saveAndCloseButton;

    @FindBy(xpath = creationOfNewProjectLocator)
    public WebElement creationOfNewProject;

    public static final String creationOfNewProjectLocator = "//*[text()='Проект сохранен']";

}
