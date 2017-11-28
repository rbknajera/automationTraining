package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	
	public BasePage(WebDriver otherDriver){
		driver = otherDriver;
	}
	
	public boolean typeOnElement(WebElement element, String text){
		try{
			element.sendKeys(text);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	 
	public String getTextFromElement(WebElement element){
		return element.getText();
	}
	 
	public boolean clickOnElement(WebElement element){
		try{
			element.click();
			return true;	
		}
		catch(Exception e){
			return false;
		}
	}
	
	public boolean clearElement(WebElement element){
		try{
			element.clear();
			return true;	
		}
		catch(Exception e){
			return false;
		}
	}
	
	public boolean waitForElementVisible(WebElement element, int timeout){
		try{
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(element));
			System.out.println("Element visible");
			return true;
		}
		catch(Exception e){
			System.out.println("Element not visible");
			return false;
		}
	}
	
	public boolean waitForElementNotVisible(WebElement element, String type, int timeout){
		try{
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.invisibilityOf(element));
			System.out.println("Element not visible");
			return true;
		}
		catch(Exception e){
			System.out.println("Element visible");
			return false;
		}
	}
	
/*	public boolean waitForElementPresent(WebElement element, String type, int timeout){
		try{
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedCondition<element.isDisplayed()>);
			System.out.println("Element present");
			return true;
		}
		catch(Exception e){
			System.out.println("Element not present");
			return false;
		}
	}*/
}
