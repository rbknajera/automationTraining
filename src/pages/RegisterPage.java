package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage {

	@FindBy(css = "h2.section")
	WebElement registerTitle;

	@FindBy(id = "ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_FirstName")
	WebElement firstNameField;

	@FindBy(id = "ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_FirstNameRequired")
	WebElement firstNameErrorMsg;

	@FindBy(id = "ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_LastName")
	WebElement lastNameField;

	@FindBy(id = "ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_LastNameRequired")
	WebElement lastNameErrorMsg;

	@FindBy(id = "ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Email")
	WebElement emailField;

	@FindBy(id = "ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_EmailRequired")
	WebElement emailErrorMsg;

	@FindBy(id = "ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_UserName")
	WebElement userNameField;

	@FindBy(id = "ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_UserNameRequired")
	WebElement userNameErrorMsg;

	@FindBy(id = "ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Password")
	WebElement passwordField;

	@FindBy(id = "ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_PasswordRequired")
	WebElement passwordErrorMsg;

	@FindBy(id = "ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_ConfirmPassword")
	WebElement confirmPasswordField;

	@FindBy(id = "ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_ConfirmPasswordRequired")
	WebElement confirmPasswordErrorMsg;

	@FindBy(id = "ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Question")
	WebElement questionField;

	@FindBy(id = "ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_QuestionRequired")
	WebElement questionErrorMsg;

	@FindBy(id = "ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Answer")
	WebElement answerField;

	@FindBy(id = "ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_AnswerRequired")
	WebElement answerErrorMsg;

	@FindBy(id = "ctl00_Main_CreateUserWizardControl___CustomNav0_StepNextButtonButton")
	WebElement submitButton;

	@FindBy(id = "ctl00_Main_InfoLabel")
	WebElement userNameExistsError;

	@FindBy(id = "ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_PasswordCompare")
	WebElement passwordCompareError;

	@FindBy(xpath = "//a[contains(@id, 'TopMenuRepeater')]")
	List<WebElement> navMenu;

	@FindBy(id = "ctl00_TopMenuRepeater_ctl00_MenuLink")
	WebElement homeMenuLink;

	@FindBy(id = "ctl00_TopMenuRepeater_ctl01_MenuLink")
	WebElement PostAnAdMenuLink;

	@FindBy(id = "ctl00_TopMenuRepeater_ctl02_MenuLink")
	WebElement MyAdsMenuLink;

	public RegisterPage(WebDriver otherDriver) {
		super(otherDriver);
		PageFactory.initElements(otherDriver, this);
	}

	public boolean verifyPageLoads() {
		if (getTextFromElement(registerTitle).equals("Register") && firstNameField.isDisplayed()
				&& submitButton.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public boolean verifyAllMandatoryFieldsMsgs(String firstNError, String lastNError, String emailError,
			String userNError, String passwError, String confirmPassError, String questionError, String answerError) {
		clickSubmitButton();
		if (getTextFromElement(firstNameErrorMsg).equals(firstNError)
				&& getTextFromElement(lastNameErrorMsg).equals(lastNError)
				&& getTextFromElement(emailErrorMsg).equals(emailError)
				&& getTextFromElement(userNameErrorMsg).equals(userNError)
				&& getTextFromElement(passwordErrorMsg).equals(passwError)
				&& getTextFromElement(confirmPasswordErrorMsg).equals(confirmPassError)
				&& getTextFromElement(questionErrorMsg).equals(questionError)
				&& getTextFromElement(answerErrorMsg).equals(answerError)) {
			return true;
		} else
			return false;
	}

	public void fillRegisterForm(String firstN, String lastN, String email, String userN, String password,
			String confPassword, String question, String answer) {
		clearAllFields();
		typeOnElement(firstNameField, firstN);
		typeOnElement(lastNameField, lastN);
		typeOnElement(emailField, email);
		typeOnElement(userNameField, userN);
		typeOnElement(passwordField, password);
		typeOnElement(confirmPasswordField, confPassword);
		typeOnElement(questionField, question);
		typeOnElement(answerField, answer);
		clickSubmitButton();
	}

	public boolean verifyUserNameErrorMsg(String errorMsg) {
		if (userNameExistsError.isDisplayed() && getTextFromElement(userNameExistsError).equals(errorMsg)) {
			return true;
		} else
			return false;
	}

	public boolean verifyComparePasswordErrorMsg(String errorMsg) {
		if (passwordCompareError.isDisplayed() && getTextFromElement(passwordCompareError).equals(errorMsg)) {
			return true;
		} else
			return false;
	}

	public void clickSubmitButton() {
		clickOnElement(submitButton);
	}

	public void clearAllFields() {
		clearElement(firstNameField);
		clearElement(lastNameField);
		clearElement(emailField);
		clearElement(userNameField);
		clearElement(passwordField);
		clearElement(confirmPasswordField);
		clearElement(questionField);
		clearElement(answerField);
	}
}
