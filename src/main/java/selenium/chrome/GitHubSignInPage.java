package selenium.chrome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GitHubSignInPage {
    private WebDriver driver;

    public GitHubSignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void signIn(String username, String password) {
        driver.findElement(By.id("login_field")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("#login > div.auth-form-body.mt-3 > form > div > input.btn.btn-primary.btn-block.js-sign-in-button")).click();
    }

    public boolean isSignInSuccessful() {
        return driver.findElement(By.cssSelector("#dashboard > div > feed-container > div.d-flex.flex-justify-between.flex-items-center > h3")).isDisplayed();
    }

    public String getErrorMessage() {
        return driver.findElement(By.cssSelector("#js-flash-container > div > div > div")).getText();
    }
}