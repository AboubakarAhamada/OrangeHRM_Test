package modules;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.LoginPage;
import utils.BrowserFactory;

import java.time.Duration;

public class Hooks {
    //TODO: Configure test run before and after
    public static WebDriver driver;
    private final LoginPage loginPage = new LoginPage();

    @Before
    public void setUp(){
        driver = BrowserFactory.getFactoryDriver();
        PageFactory.initElements(driver, loginPage);
    }

    @After
    public  void tearDown(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.tagName("div")));
        driver.quit();
    }
}
