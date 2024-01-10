package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver createDriver(String browser) {
        WebDriver driver;

        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "\"C:\\Users\\MASS\\git\\HalaTraining2\\chromedriver.exe\""); 
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "\"C:\\Users\\MASS\\git\\HalaTraining2\\geckodriver.exe\""); 
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "\"C:\\Users\\MASS\\git\\HalaTraining2\\msedgedriver.exe\""); 
                driver = new EdgeDriver();
                break;
            default:
                driver = new ChromeDriver(); // 
        }

        return driver;
    }

}
