package seleautomation.com.HalaTraining1;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.DriverFactory;

public class GitHubtest {

    @DataProvider(name = "testData")
    public Object[][] provideTestData() {
        return new Object[][] {
                // TC001: Valid Sign-In
                {"asaltest19@gmail.com", "password123456789s*", true},
                // TC002: Invalid Username
                {"asaltest1646449@gmail.com", "password123456789s*", false},
                // TC003: Invalid Password
                {"asaltest19@gmail.com", "password123456789sgg", false},
                // TC004: Empty Fields
                {"", "", false},
        };
    }

    @Test(dataProvider = "testData")
    public void testSignIn(String username, String password, boolean expectedResult) {
        WebDriver driver = DriverFactory.createDriver("chrome"); // Adjust browser type as needed

        GitHubHomePage homePage = new GitHubHomePage(driver);
        GitHubSignInPage signInPage = homePage.navigateToSignIn();

        signInPage.signIn(username, password);

        // Assert sign-in results (refactored with two if statements)
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