package testPackage;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.NavigationPage;

public class HomePageTests extends BaseTest{
	String baseUrl = "http://qa-trainingw7:86/";
	HomePage homePage;
	NavigationPage navPage;
	
	@Test
	//Verify the "Home" page is displayed correctly when loading the app
	public void testVerifyHomePageLoadsCorrectly() throws Exception{
		driver.get(baseUrl);
		homePage = new HomePage(driver);
		assertEquals(homePage.verifyThePageLoads(), true);
	}
	
	@Test
	//Verify the "Home" page is displayed correctly when clicking on "Home" tab on the nav menu
	public void testVerifyHomePageLoadsCorrectlyFromTabMenu(){
		driver.get(baseUrl);
		navPage = new NavigationPage(driver);
		homePage = navPage.goToHomePage();
		assertEquals(homePage.verifyThePageLoads(), true);
	}

}
