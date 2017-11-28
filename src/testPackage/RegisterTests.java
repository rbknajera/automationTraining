package testPackage;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.RegisterPage;

public class RegisterTests extends BaseTest {
	String baseURL = "http://qa-trainingw7:86/";
	RegisterPage registerPage;
	HomePage homePage;

	@Test
	// Verify the "Register" page is displayed correctly when clicking on
	// "Register link"
	public void testVerifyTheRegisterPageIsDisplayedCorrectly() throws Exception {
		driver.get(baseURL);
		homePage = new HomePage(driver);
		registerPage = homePage.goToRegisterPage();
		assertEquals(registerPage.verifyPageLoads(), true);
	}

	@Test
	// Verify all the mandatory messages are displayed when leaving empty all
	// the mandatory fields and clicking on "Submit" button
	public void testVerifyAllTheMandatoryMessages() throws Exception {
		driver.get(baseURL);
		homePage = new HomePage(driver);
		registerPage = homePage.goToRegisterPage();
		registerPage.clickSubmitButton();
		assertEquals(registerPage.verifyAllMandatoryFieldsMsgs("First name is required.", "Last name is required.",
				"Email is required.", "User name is required.", "Password is required.",
				"Confirm password is required.", "Security question is required.", "Security answer is required."),
				true);
	}

	@Test
	// Verify an error message is displayed when creating an user with an user
	// name that is already taken
	public void testVerifyErrorDisplayedWhenUsingExistingUserName() throws Exception {
		driver.get(baseURL);
		homePage = new HomePage(driver);
		registerPage = homePage.goToRegisterPage();
		registerPage.fillRegisterForm("FirstName", "LastName", "email@email.com", "rebenajera", "Password-",
				"Password-", "Question", "Answer");
		assertEquals(
				registerPage.verifyUserNameErrorMsg("User name already exists. Please enter a different user name."),
				true);
	}

	@Test
	// Verify an error message is displayed when sending a different password on
	// 'Password' and 'Confirm Password' fields.
	public void testVerifyErrorDisplayedWhenPasswordDoesNotMatchWithConfirmPassword() throws Exception {
		driver.get(baseURL);
		homePage = new HomePage(driver);
		registerPage = homePage.goToRegisterPage();
		registerPage.fillRegisterForm("FirstName", "LastName", "email@email.com", "UserName", "Password-", "Password",
				"Question", "Answer");
		assertEquals(registerPage.verifyComparePasswordErrorMsg("The password and confirmation password must match."),
				true);
	}
}
