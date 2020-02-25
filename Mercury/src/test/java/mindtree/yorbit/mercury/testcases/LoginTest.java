/**
 * 
 */
package mindtree.yorbit.mercury.testcases;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import mindtree.yorbit.mercury.base.BaseTest;
import mindtree.yorbit.mercury.pageobjects.FindFlightsPage;
import mindtree.yorbit.mercury.pageobjects.HeaderLinksPage;
import mindtree.yorbit.mercury.pageobjects.LoginPage;
import mindtree.yorbit.mercury.util.ExcelUtilities;

/**
 * @author M1044400
 *
 */
public class LoginTest extends BaseTest {
	private static final Logger log = LogManager.getLogger(LoginTest.class);

	

	@Test(priority = 1, dataProvider = "loginData")
	public void login(String uName, String password) {
		LoginPage loginPage = LoginPage.getLoginpage(getDriver());
		wait=new WebDriverWait(getDriver(), 20);
		wait.until(ExpectedConditions.visibilityOf(loginPage.signInButton));
		loginPage.enterUserName(uName);
		loginPage.enterPassword(password);
		loginPage.clickOnSignIN();
		FindFlightsPage findFlightsPage = FindFlightsPage.getFindFlightsPage(getDriver());
		if(findFlightsPage.twoWayTrip.isDisplayed()) {
		logStatus(log, test, "pass", "User logged-in successfully");
		takeScreenShot(test);
		}else {
			logStatus(log, test, "fail", "User logged-in failed");
		}

		HeaderLinksPage headerLinksPage = HeaderLinksPage.getHeaderLinksPage(getDriver());
		headerLinksPage.clickOnSignOff();
		
	}

	@DataProvider(name = "loginData")
	public Object[][] getConfigData() {
		return ExcelUtilities.getDataFromSpreadSheet("Login.xlsx", "Login");

	}

	

}
