/**
 * 
 */
package mindtree.yorbit.mercury.testcases;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import mindtree.yorbit.mercury.base.BaseTest;
import mindtree.yorbit.mercury.pageobjects.HeaderLinksPage;
import mindtree.yorbit.mercury.pageobjects.LoginPage;
import mindtree.yorbit.mercury.pageobjects.RegisterPage;

/**
 * @author M1044400
 *
 */
public class HeaderHyperlinkTest extends BaseTest {
	private static final Logger log = LogManager.getLogger(HeaderHyperlinkTest.class);


	@Test(priority = 1)
	public void hyperLinks() {
		HeaderLinksPage headerLink = HeaderLinksPage.getHeaderLinksPage(getDriver());
		headerLink.clickOnSignOn();
		LoginPage loginPage = LoginPage.getLoginpage(getDriver());
		if(loginPage.signInButton.isDisplayed()) {
			logStatus(log, test, "pass", "SIGN-ON Link clicked successfully");
			takeScreenShot(test);
			}else {
				logStatus(log, test, "fail", "SIGN-ON not clicked");
			}
		
		headerLink.clickOnRegister();
		RegisterPage registerPage = RegisterPage.getRegisterPage(getDriver());
		if(registerPage.fName.isDisplayed()) {
			logStatus(log, test, "pass", "REGISTER Link clicked successfully");
			takeScreenShot(test);
			}else {
				logStatus(log, test, "fail", "REGISTER not clicked");
			}
		
		headerLink.clickOnSupport();
		if(headerLink.backToHomeButton.isDisplayed()) {
			logStatus(log, test, "pass", "SUPPORT Link clicked successfully");
			takeScreenShot(test);
			}else {
				logStatus(log, test, "fail", "SUPPORT not clicked");
			}
		headerLink.clickOnBackToHome();
		
		headerLink.clickOnContact();
		if(headerLink.backToHomeButton.isDisplayed()) {
			logStatus(log, test, "pass", "CONTACT Link clicked successfully");
			takeScreenShot(test);
			}else {
				logStatus(log, test, "fail", "CONTACT not clicked");
			}
	}


}