package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;
import java.util.Properties;

public class BrowserFactory {
    //TODO: Configure browser properties
    static WebDriver driverFactory;
    static String filePath = "src/test/resources/environment/config.properties";

    static PropertyFileReader propertyFileReader = new PropertyFileReader();
    static Properties browserType;

    static {
        try {
            browserType = propertyFileReader.readProperty(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static WebDriver getFactoryDriver(){
        switch (browserType.getProperty("browser")) {
            case "firefox" -> {
                System.setProperty("webdriver.firefox.driver", "src/test/resources/drivers/geckodriver.exe");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");
                driverFactory = new FirefoxDriver(firefoxOptions);
            }
            case "edge" -> {
                System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximize");
                driverFactory = new EdgeDriver(edgeOptions);
            }
            default -> {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                driverFactory = new ChromeDriver(chromeOptions);
            }
        }

        return driverFactory;
    }
}
