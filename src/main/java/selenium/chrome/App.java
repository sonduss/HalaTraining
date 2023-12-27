package selenium.chrome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {

    public static void main(String[] args) {
        // Set up WebDriver
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\MASS\\eclipse-workspace\\chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to Google
            driver.get("https://www.google.com");

            // ... (Perform search actions here)
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}