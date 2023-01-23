package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.LoginPage;

import java.time.Duration;

import static modules.Hooks.driver;

public class LoginStepDefinition {
    @Given("I open the OrangeHRM login page")
    public void iOpenTheOrangeHRMLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.tagName("button")));
    }

    @When("I enter {string} as username and {string} as password")
    public void iEnterAsUsernameAndAsPassword(String username, String password) {
        LoginPage.getUsernameField().sendKeys(username);
        LoginPage.getPasswordField().sendKeys(password);
    }

    @And("I click on the Login button")
    public void iClickOnTheLoginButton() {
        LoginPage.getLoginButton().click();
    }

    @Then("I can access to the admin page")
    public void iCanAccessToTheAdminPage() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.tagName("button")));
        Assert.assertTrue(driver.getCurrentUrl().contains("https://opensource-demo.orangehrmlive.com/web/index.php"));

    }

}
