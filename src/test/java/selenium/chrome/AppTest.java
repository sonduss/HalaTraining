package selenium.chrome;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import selenium.chrome.GitHubHomePage;
import selenium.chrome.GitHubSignInPage;
import utilities.DataReader;
import utilities.DriverFactory;

public class AppTest {

    @DataProvider(name = "testData")
    public Object[][] provideTestData() {
        DataReader reader = new DataReader("\"C:\\Users\\MASS\\OneDrive\\Desktop\\QA.xlsx\""); 
        return reader.readTestData();
    }

    @Test(dataProvider = "testData")
    public void testSignIn(String testCaseId, String username, String password, boolean expectedResult) {
        WebDriver driver = DriverFactory.createDriver("chrome"); 

        GitHubHomePage homePage = new GitHubHomePage(driver);
        GitHubSignInPage signInPage = homePage.navigateToSignIn();

        signInPage.signIn(username, password);

        // Assert sign-in results
        if (expectedResult) {
            Assert.assertTrue(signInPage.isSignInSuccessful(), "Sign-in failed unexpectedly.");
        } else {
            Assert.assertFalse(signInPage.isSignInSuccessful(), "Sign-in succeeded unexpectedly.");
            Assert.assertEquals(signInPage.getErrorMessage(), "Incorrect username or password."); 
        }

        // Close the browser
        driver.quit();
    }
}