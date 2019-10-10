#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.testbase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import ${package}.constants.Constants;
import ${package}.utils.Utility;

/**
	 * Different browser setup to run the script in different different browser.
	 * 
	 * @author ranjitha.selvam
	 *
	 */

	public class Browsers {

		public static WebDriver driver;

		@BeforeTest
		public void browserSetup() throws IOException {

			String url = Utility.propertyRead(Constants.config_file,"url");

			String browserName =Utility.propertyRead(Constants.config_file, "browserName");

			

			if (browserName.equals("CHROME")) {
				System.setProperty("webdriver.chrome.driver", Constants.chrome_file);
				driver = new ChromeDriver();
			} else if (browserName.equals("FIREFOX")) {
				System.setProperty("webdriver.gecko.driver", Constants.fireFox_file);
				driver = new FirefoxDriver();
			} else if (browserName.equals("INTERNETEXPLORER")) {
				System.setProperty("webdriver.ie.driver", Constants.internetExplorer_file);
				driver = new InternetExplorerDriver();
			}
		
		

			driver.get(url);

			driver.manage().window().maximize();
		}

		@AfterTest()
		public void browserClose() {
			driver.close();

		}

	}

	


