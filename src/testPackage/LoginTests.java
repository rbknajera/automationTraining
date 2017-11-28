package testPackage;

import org.testng.annotations.*;

import pages.HomePage;
import pages.LoginPage;

import static org.testng.Assert.*;

public class LoginTests extends BaseTest {
	String baseUrl = "http://qa-trainingw7:86/";
	LoginPage loginPage;
	HomePage homePage;

	@Test
	// Verify the "Login" page is displayed correctly when clicking "Login" link
	public void testVerifyTheLoginPageIsDisplayedCorrectly() throws Exception {
		driver.get(baseUrl);
		homePage = new HomePage(driver);
		if (homePage.verifyThePageLoads() == true) {
			loginPage = homePage.goToLoginPage();
			assertEquals(loginPage.verifyThePageLoads(), true);

		} else
			System.out.println("Home Page did not load correctly.");
	}

	@Test
	// Verify the user is able to login when sending valid credentials
	public void testVerifyTheUserIsAbleToLoginWhenSendingValidCredentials() throws Exception {
		driver.get(baseUrl + "/Login.aspx");
		loginPage = new LoginPage(driver);
		loginPage.logIn("rebenajera", "automation-test");
		assertEquals(homePage.verifyUserName("rebenajera"), true);
		homePage.logOut();
	}

	@Test
	// Verify the user is not able to login when sending invalid credentials
	public void testVerifyTheUserIsNotAbleToLoginWhenSendingInvalidCredentials() throws Exception {
		driver.get(baseUrl + "/Login.aspx");
		loginPage = new LoginPage(driver);
		loginPage.logIn("wrongUserName", "wrongPassword");
		assertEquals(loginPage.verifyErrorMsg("Your login attempt was not successful. Please try again."), true);
	}
}
