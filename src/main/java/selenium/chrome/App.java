package selenium.chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class App {

    public static void main(String[] args) {
        // Set up WebDriver
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\MASS\\eclipse-workspace\\chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to Google
            driver.get("https://www.google.com");

            // Click inside the search box
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.click();

            // Type the search query
            searchBox.sendKeys("Selenium Tutorials");

            // Submit the search
            searchBox.sendKeys(Keys.ENTER);

            // Validate the title
            String expectedTitle = "Selenium Tutorials - Google Search"; // Adjust as needed
            String actualTitle = driver.getTitle();
            
            // Assert the title
            Assert.assertEquals(expectedTitle, actualTitle);

        } catch (Exception e) {
            // Handle exceptions if needed
            e.printStackTrace();
        } finally {
            // Close the browser
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
