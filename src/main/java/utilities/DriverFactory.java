package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

    public static WebDriver createDriver(String browser) {
        WebDriver driver;

        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\MASS\\eclipse-workspace\\chrome\\chromedriver.exe"); // Replace with your ChromeDriver path
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\MASS\\eclipse-workspace\\chrome\\firefoxdriver.exe"); // Replace with your GeckoDriver path
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "C:\\Users\\MASS\\eclipse-workspace\\chrome\\edgedriver.exe"); // Replace with your EdgeDriver path
                driver = new EdgeDriver();
                break;
            default:
                driver = new ChromeDriver(); // Default to Chrome if browser is not specified
        }

        return driver;
    }

}