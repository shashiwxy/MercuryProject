package mindtree.yorbit.mercury.pageobjects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mindtree.yorbit.mercury.base.BaseTest;
import mindtree.yorbit.mercury.exceptions.ElementNotClickable;
import mindtree.yorbit.mercury.exceptions.ElementNotPresentException;
import mindtree.yorbit.mercury.exceptions.LocatorNotFound;
import mindtree.yorbit.mercury.util.Actions;


public class LoginPage extends BaseTest{
	private static final Logger log = LogManager.getLogger(LoginPage.class);	
	
	@FindBy(xpath = "//input[@name='userName']")
	@CacheLookup
    private WebElement userID;

    @FindBy(xpath = "//input[@name='password']")
    @CacheLookup
    private WebElement password;

    @FindBy(xpath = "//input[@name='login']")
    @CacheLookup
    public WebElement signInButton;
    
    public void enterUserName(String setUserID) {
    	try {
			Actions.insertValuesInATextField(userID, setUserID);
		} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }
    public void enterPassword(String setPassword) {
    	try {
			Actions.insertValuesInATextField(password, setPassword);
		} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }
    public void clickOnSignIN(){
    	try {
    		Actions.clickElement(signInButton);
    	} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }
    
    public static LoginPage getLoginpage(WebDriver driver){
    	return PageFactory.initElements(driver, LoginPage.class);
    }
}
