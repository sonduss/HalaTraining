package selenium.chrome;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class AppTest {

    @Test
    public void testGoogleSearch() {
        // Set up WebDriver (using the same setup as in the main code)
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\MASS\\eclipse-workspace\\chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to Google
            driver.get("https://www.google.com");

            // Perform search actions
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.click();
            searchBox.sendKeys("Selenium Tutorials");
            searchBox.sendKeys(Keys.ENTER);

            // Validate the title
            String expectedTitle = "Selenium Tutorials - Google Search";
            String actualTitle = driver.getTitle();
            Assert.assertEquals(expectedTitle, actualTitle);
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}