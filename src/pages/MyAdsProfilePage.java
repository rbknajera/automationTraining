package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyAdsProfilePage extends BasePage{

	public MyAdsProfilePage(WebDriver otherDriver) {
		super(otherDriver);
		PageFactory.initElements(otherDriver, this);
	}
	

}
