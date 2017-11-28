package testPackage;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import pages.BasePage;

public class BaseTest {

	protected WebDriver driver;
	protected DesiredCapabilities capability;
	BasePage basePage;

	@BeforeTest
	@Parameters({ "browser", "platform", "mode" })
	public void setUpTest(String browser, String platform, String mode) throws MalformedURLException {
		if (mode.equalsIgnoreCase("local")) {
			driver = createLocalDriver(browser);
		} else if (mode.equalsIgnoreCase("remote")) {
			driver = createRemoteDriver(browser, platform);
		}
	}

	public WebDriver createLocalDriver(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\rnajera-as\\workspace\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\rnajera-as\\workspace\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;
	}

	public WebDriver createRemoteDriver(String browser, String platform) throws MalformedURLException {
		if (browser.equalsIgnoreCase("firefox")) {
			capability = DesiredCapabilities.firefox();
			driver = new RemoteWebDriver(new URL("http...."), capability);
		} else if (browser.equalsIgnoreCase("chrome")) {
			capability = DesiredCapabilities.chrome();
			driver = new RemoteWebDriver(new URL("http..."), capability);
		}
		return driver;
	}

	@AfterTest(alwaysRun = true)
	public void tearDown() throws Exception {
			driver.quit();
	}

}
