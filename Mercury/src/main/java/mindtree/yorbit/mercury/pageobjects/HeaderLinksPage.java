/**
 * 
 */
package mindtree.yorbit.mercury.pageobjects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mindtree.yorbit.mercury.base.BaseTest;
import mindtree.yorbit.mercury.exceptions.ElementNotClickable;
import mindtree.yorbit.mercury.exceptions.ElementNotPresentException;
import mindtree.yorbit.mercury.exceptions.LocatorNotFound;
import mindtree.yorbit.mercury.util.Actions;

/**
 * @author DEEPAK
 *
 */
public class HeaderLinksPage extends BaseTest{
	private static final Logger log = LogManager.getLogger(Exception.class);
	
	@FindBy(xpath = "//a[contains(text(),'SIGN-ON')]")
    private WebElement signOn;
	
	@FindBy(xpath = "//a[contains(text(),'SIGN-OFF')]")
    private WebElement signOff;
	
	@FindBy(xpath = "//a[contains(text(),'REGISTER')]")
    private WebElement register;
	
	@FindBy(xpath = "//a[contains(text(),'SUPPORT')]")
    private WebElement support;
	
	@FindBy(xpath = "//a[contains(text(),'CONTACT')]")
    private WebElement contact;
	
	 @FindBy(xpath ="//img[@src='/images/forms/home.gif']")
	 public WebElement backToHomeButton;
	
    public void clickOnSignOn() {
    	try {
    		Actions.clickElement(signOn);
    	} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }

    
    public void clickOnSignOff() {
    	try {
    		Actions.clickElement(signOff);
    	} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }

    
    public void clickOnContact() {
    	try {
    		Actions.clickElement(contact);
    	} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }

    public void clickOnRegister() {
    	try {
    		Actions.clickElement(register);
    	} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }

    public void clickOnSupport() {
    	try {
    		Actions.clickElement(support);
    	} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }
    
    public void clickOnBackToHome(){
    	try {
    		Actions.clickElement(backToHomeButton);
    	} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }
    

    public static HeaderLinksPage getHeaderLinksPage(WebDriver driver){
    	return PageFactory.initElements(driver, HeaderLinksPage.class);
    }
}
