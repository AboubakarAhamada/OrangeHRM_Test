package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static modules.Hooks.driver;

public class EmployeeStepDefinition {
    @Given("User opens URL {string}")
    public void userOpensURL(String baseUrl) {
        driver.get(baseUrl);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.tagName("button")));
    }

    @When("User Enters username as {string} and Password as {string}")
    public void userEntersUsernameAsAndPasswordAs(String username, String password) {
        WebElement usernameFiled =  driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        usernameFiled.sendKeys(username);
        passwordField.sendKeys(password);

    }

    @And("Click on Login")
    public void clickOnLogin() {
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();
    }

    // ==========  Add user steps ===============
    @When("User clicks PIM menu")
    public void userClicksPIMMenu() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.tagName("ul")));
        WebElement pimMenu = driver.findElement(By.cssSelector("ul li:nth-of-type(2)"));
        pimMenu.click();
    }

    @And("clicks on Add Employee menu item")
    public void clicksOnAddEmployeeMenuItem() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.tagName("button")));
        driver.findElement(
                By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")
        ).click();
    }

    @Then("User fills info of new Employee {string} {string} {string}")
    public void userFillsInfoOfNewEmployee(String firstname,
                                           String middlename, String lastname) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.tagName("button")));
        driver.findElement(By.name("firstName")).sendKeys(firstname);
        driver.findElement(By.name("middleName")).sendKeys(middlename);
        driver.findElement(By.name("lastName")).sendKeys(lastname);
    }

    @And("clicks on Save button")
    public void clicksOnSaveButton() {
        driver.findElement(By.xpath("//button[text()=' Save ']")).click();
    }

    @Then("User is added successfully")
    public void userIsAddedSuccessfully() {

    }

    // ============== Search for user steps ===============
    @When("User clicks over PIM menu")
    public void userClicksOverPIMMenu() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.tagName("ul")));
        driver.findElement(By.cssSelector("ul li:nth-of-type(2)")).click();
    }

    @And("Clicks on Employee List menu item")
    public void clicksOnEmployeeListMenuItem() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.tagName("button")));
        driver.findElement(
                By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/a")
        ).click();
    }

    @When("User looks for this employee {string}")
    public void userLooksForThisEmployeeEmployeeName( String username) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.tagName("button")));
        driver.findElement(
                By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]" +
                        "/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")
        ).sendKeys(username);
    }

    @And("clicks on Search button")
    public void clicksOnSearchButton() {
        driver.findElement(By.xpath("//button[text()=' Search ']"))
                .click();
    }

    @Then("it displays results")
    public void itDisplaysResults() {

    }

    // ============== Delete user steps ================
    @When("User clicks on the checkbox")
    public void userClicksOnTheCheckbox() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.tagName("input")));
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
    }

    @And("clicks on delete button")
    public void clicksOnDeleteButton() {
        driver.findElement(By.xpath("//button[text()= ' Delete Selected ']")).click();
    }

    @Then("confirmation pop up will appear")
    public void confirmationPopUpWillAppear() {
    }

    @When("User confirms delete")
    public void userConfirmsDelete() {
    }

    @And("record will be deleted")
    public void recordWillBeDeleted() {
    }
}
