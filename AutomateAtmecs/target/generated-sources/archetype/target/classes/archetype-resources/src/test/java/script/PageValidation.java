#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.script;

import java.io.IOException;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ${package}.constants.Constants;
import ${package}.helper.Helper;
import ${package}.report.LogReport;
import ${package}.testbase.Browsers;
import ${package}.utils.Utility;
import ${package}.validation.Validation;



/**
 * Verify home page click options(Explore Now and More Info) and validate
 * whether user landed successfully after clicking more info.
 * 
 * @author ranjitha.selvam
 *
 */
public class PageValidation extends Browsers {
	
	


	@Test(priority = 1)
	public void clickOptionsExplore() throws Exception {
		
		LogReport.info("login into atmecs");
        Helper.click(driver, Utility.propertyRead(Constants.homePage_loc, "loc_home_xpath_link"));
        LogReport.info("click option explore now in home page");
        Helper.click(driver, Utility.propertyRead(Constants.homePage_loc, "loc_explore_xpath_clk"));
     
		Helper.navigate(driver);
	}
	
	

	
	@DataProvider
	public Object[][] homePageData() throws Exception {
		Object data[][] = Utility.getExcel(Constants.homePage_testData, "Sheet1");
		return data;
	}
	
	

	@Test(dataProvider = "homePageData", priority = 2)
	public void clickOptionMoreInfo(String moreInfo, String breadCrumb) throws IOException {
	    Helper.implicitWait(driver);
	    String homePageHeader = Helper.getText(driver,Utility.propertyRead(Constants.homePage_loc,"loc_homeheader_xpath_txt"));
		Helper.click(driver, moreInfo);
	    String actualBreadCrumb = Helper.getText(driver,Utility.propertyRead(Constants.homePage_loc,"loc_breadcrumb_xpath_txt"));
		Helper.navigate(driver);
		
		if(!homePageHeader.equals(actualBreadCrumb))
		{
			LogReport.info("user landed successfully before after clicking more info");
		}
		
		Validation.pageValidation(actualBreadCrumb , breadCrumb);
		

				
		
}
}
