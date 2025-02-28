package Test20250228.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebFormPage {

    //ToDo add plumbing for remaining elements on form
    // didn't have a lot of time to look at this so only implemented two of the form fields.

    private WebDriver driver;
    private By textInput = By.id("my-text-id");
    private By dropdownSelect = By.name("my-select");
    private By submitButton = By.className("btn-outline-primary");
    private By submissionMessage = By.id("message");

    public WebFormPage(WebDriver driver) {
        this.driver = driver;
    }

    // ToDo - would definitely parameterise this... but given this is a simple example and I'm short on time I'm keeping it simple.
    public void openPage() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    }

    public void EnterTextInput(String value) {
        driver.findElement(textInput).sendKeys(value);
    }

    public WebElement getTextInput() {
        return driver.findElement(textInput);
    }

    public WebElement getDropdownSelect() {
        return driver.findElement(dropdownSelect);
    }

    public WebElement getSubmitButton() {
        return driver.findElement(submitButton);
    }

    public void selectOptionByTextInDropdownSelect(String visibleText) {
        Select dropdown = new Select(getDropdownSelect());
        dropdown.selectByVisibleText(visibleText);
    }

    public String getSelectedOptionInDropDownSelect() {
        Select dropdown = new Select(getDropdownSelect());
        return dropdown.getFirstSelectedOption().getText();
    }

    public void submitForm() {
        getSubmitButton().click();
    }

    public String getFormSubmissionMessage() {
        return driver.findElement(submissionMessage).getText();
    }
}