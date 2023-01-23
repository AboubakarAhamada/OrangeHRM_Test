package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(name = "username")
    private  static WebElement usernameField;
    @FindBy(name = "password")
    private static WebElement passwordField;
    @FindBy(tagName = "button")
    private static WebElement loginButton;

    public static WebElement getUsernameField() {
        return usernameField;
    }

    public static WebElement getPasswordField() {
        return passwordField;
    }

    public static WebElement getLoginButton() {
        return loginButton;
    }
}
