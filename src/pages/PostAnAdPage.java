package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PostAnAdPage extends BasePage{

	public PostAnAdPage(WebDriver otherDriver) {
		super(otherDriver);
		PageFactory.initElements(otherDriver, this);
	}
	

}
