package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	@FindBy(className = "section")
	WebElement categoriesTitle;

	@FindBy(xpath = "//a[contains(@id, 'TopCategoryButton')]")
	List<WebElement> allCategories;

	@FindBy(xpath = "//a[contains(@id, 'TopMenuRepeater')]")
	List<WebElement> navMenu;

	@FindBy(id = "ctl00_LoginView_MemberName")
	WebElement userName;

	@FindBy(id = "ctl00_LoginView_LoginLink")
	WebElement loginButton;

	@FindBy(id = "ctl00_LoginView_RegisterLink")
	WebElement registerButton;

	@FindBy(id = "ctl00_LoginView_MemberLoginStatus")
	WebElement logutButton;

	@FindBy(id = "ctl00_TopMenuRepeater_ctl00_MenuLink")
	WebElement homeMenuLink;

	@FindBy(id = "ctl00_TopMenuRepeater_ctl01_MenuLink")
	WebElement PostAnAdMenuLink;

	@FindBy(id = "ctl00_TopMenuRepeater_ctl02_MenuLink")
	WebElement MyAdsMenuLink;

	public HomePage(WebDriver otherDriver) {
		super(otherDriver);
		PageFactory.initElements(otherDriver, this);
	}

	public boolean verifyThePageLoads() {
		String pageTitle = getTextFromElement(categoriesTitle);
		if (pageTitle.equals("Browse Categories") && allCategories.size() == 7 && navMenu.size() == 3) {
			return true;
		} else
			return false;
	}

	public boolean verifyUserName(String user) {
		if (waitForElementVisible(userName, 10) == true) {
			if (getTextFromElement(userName).equals(user)) {
				return true;
			} else
				return false;
		} else
			return false;
	}

	public void logOut() {
		clickOnElement(logutButton);
	}

	public LoginPage goToLoginPage() {
		clickOnElement(loginButton);
		return new LoginPage(driver);
	}

	public RegisterPage goToRegisterPage() {
		clickOnElement(registerButton);
		return new RegisterPage(driver);
	}
}
