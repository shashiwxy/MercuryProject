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
import mindtree.yorbit.mercury.pageobjects.HeaderLinksPage;
import mindtree.yorbit.mercury.pageobjects.RegisterPage;
import mindtree.yorbit.mercury.util.ExcelUtilities;

/**
 * @author M1044400
 *
 */
public class RegistrationTest extends BaseTest {
	private static final Logger log = LogManager.getLogger(RegistrationTest.class);


	@Test(priority = 1, dataProvider = "registrationData")
	public void registration(String setFName, String setLName, String phoneNumber, String setEmail,
			String setaddress, String setCity, String setState, String setPostal, String setCountry, String setUserName,
			String setPassword, String setConfirmPassword) {
		HeaderLinksPage headerLinksPage = HeaderLinksPage.getHeaderLinksPage(getDriver());
		headerLinksPage.clickOnRegister();
		RegisterPage registerPage = RegisterPage.getRegisterPage(getDriver());
		logStatus(log, test, "info", "clicked on registration link");
		wait=new WebDriverWait(getDriver(), 20);
		wait.until(ExpectedConditions.visibilityOf(registerPage.fName));
		
		registerPage.enterFirstName(setFName);
		registerPage.enterLastName(setLName);
		registerPage.enterPhoneNumber(phoneNumber);
		registerPage.enterEmail(setEmail);
		registerPage.enterAddress(setaddress);
		registerPage.enterCity(setCity);
		registerPage.enterState(setState);
		registerPage.enterPostal(setPostal);
		registerPage.enterCountry(setCountry);
		registerPage.enterUserName(setUserName);
		registerPage.enterPassword(setPassword);
		registerPage.enterConfirmPasswprd(setConfirmPassword);
		registerPage.clickOnSubmitButton();
		String message=registerPage.getRegisteredDetails();
		logStatus(log, test, "pass", message);
		

}
	@DataProvider(name = "registrationData")
	public Object[][] getConfigData() {
		return ExcelUtilities.getDataFromSpreadSheet("Registration.xlsx", "registration");

	}

}
