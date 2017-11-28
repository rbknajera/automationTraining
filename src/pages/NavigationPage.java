package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationPage extends BasePage{
	
	@FindBy(id = "ctl00_TopMenuRepeater_ctl00_MenuLink")
	WebElement homeMenuLink;

	@FindBy(id = "ctl00_TopMenuRepeater_ctl01_MenuLink")
	WebElement postAnAdMenuLink;

	@FindBy(id = "ctl00_TopMenuRepeater_ctl02_MenuLink")
	WebElement myAdsMenuLink;
	
	@FindBy(xpath = "//a[contains(@id, 'TopMenuRepeater')]")
	List<WebElement> navMenu;
	
	public NavigationPage(WebDriver otherDriver){
		super(otherDriver);
		PageFactory.initElements(otherDriver, this);
	}
	
	public boolean verifyThePageLoads() {
		if (navMenu.size() == 3) {
			return true;
		} else
			return false;
	}
	
	public HomePage goToHomePage(){
		clickOnElement(homeMenuLink);
		return new HomePage(driver);
	}
	
	public PostAnAdPage goToPostAnAdPage(){
		clickOnElement(postAnAdMenuLink);
		return new PostAnAdPage(driver);
	}
	
	public MyAdsProfilePage goToMyAdsProfilePage(){
		clickOnElement(myAdsMenuLink);
		return new MyAdsProfilePage(driver);
	}

}
