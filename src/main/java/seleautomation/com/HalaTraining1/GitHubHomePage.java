package seleautomation.com.HalaTraining1;

/**
 * Hello world!
 *
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GitHubHomePage {

    public static void main(String[] args) {
    
    }
    private WebDriver driver;
    private final String signInUrl = "https://github.com/login"; 

    public GitHubHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public GitHubSignInPage navigateToSignIn() {
    	driver.get(signInUrl); 
        return new GitHubSignInPage(driver);
    }
}
