package Test20250228.steps;

import Test20250228.pages.WebFormPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StepDefinitions  {

    private WebDriver driver;
    private WebFormPage page;

    // ToDo - Depending on the requirements of the project, I would likely implement a more sophisticated way
    //  of handling browser selection.
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        page = new WebFormPage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // These steps are very basic. And I don't like implementing steps that are so "technical"
    // But in the absence of real requirements, this is the general idea...
    @Given("I am on the form")
    public void navigateToHomePage(){
        page.openPage();
    }

    @When("I enter {string} in the Text Input field")
    public void enterText(String text) {
        page.EnterTextInput(text);
    }

    @When("the text {string} should display correctly in the Text Input field")
    public void checkVisibleTextInTextInputField(String expected) {
        assertThat(page.getTextInput().getAttribute("value")).isEqualTo(expected);
    }

    @When("I select {string} from the dropdown select control")
    public void selectByTextFromDropdownSelect(String selection) {
        page.selectOptionByTextInDropdownSelect(selection);
    }

    @Then("the text {string} should be the the visible selection in the dropdown select control")
    public void checkSelectedTextInDropDownSelect(String expected) {
        assertThat(page.getSelectedOptionInDropDownSelect()).isEqualTo(expected);
    }

    @Then("The form can be submitted successfully")
    public void submitForm() {
        page.submitForm();
        assertThat(page.getFormSubmissionMessage()).isEqualTo("Received!");
    }
}