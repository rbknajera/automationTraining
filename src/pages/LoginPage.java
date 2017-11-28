package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

	@FindBy(css = "h2.section")
	WebElement loginTitle;

	@FindBy(id = "ctl00_Main_LoginConrol_UserName")
	WebElement userNameField;

	@FindBy(id = "ctl00_Main_LoginConrol_Password")
	WebElement passwordField;

	@FindBy(id = "ctl00_Main_LoginConrol_LoginButton")
	WebElement logInButton;

	@FindBy(xpath = "//td[contains(text(), 'Your login attempt was not successful')]")
	WebElement errorMsgField;

	@FindBy(xpath = "//a[contains(@id, 'TopMenuRepeater')]")
	List<WebElement> navMenu;

	@FindBy(id = "ctl00_TopMenuRepeater_ctl00_MenuLink")
	WebElement homeMenuLink;

	@FindBy(id = "ctl00_TopMenuRepeater_ctl01_MenuLink")
	WebElement PostAnAdMenuLink;

	@FindBy(id = "ctl00_TopMenuRepeater_ctl02_MenuLink")
	WebElement MyAdsMenuLink;

	public LoginPage(WebDriver otherDriver) {
		super(otherDriver);
		PageFactory.initElements(otherDriver, this);
	}

	public boolean verifyThePageLoads() {
		String pageTitle = getTextFromElement(loginTitle);
		if (pageTitle.equals("Login") && waitForElementVisible(userNameField, 5) == true
				&& waitForElementVisible(passwordField, 5) == true && navMenu.size() == 3) {
			return true;
		} else
			return false;
	}

	public boolean verifyLoginTitle(String title) {
		String pageTitle = getTextFromElement(loginTitle);
		if (waitForElementVisible(loginTitle, 10) == true) {
			if (pageTitle.equals(title)) {
				return true;
			} else
				return false;
		} else
			return false;
	}

	public void clearAllFields() {
		clearElement(userNameField);
		clearElement(passwordField);
	}

	public void logIn(String userName, String password) {
		clearAllFields();
		typeOnElement(userNameField, userName);
		typeOnElement(passwordField, password);
		clickOnElement(logInButton);
	}

	public boolean verifyErrorMsg(String errorMsg) {
		if (errorMsgField.isDisplayed() == true && getTextFromElement(errorMsgField).equals(errorMsg)) {
			return true;
		} else
			return false;
	}
}
