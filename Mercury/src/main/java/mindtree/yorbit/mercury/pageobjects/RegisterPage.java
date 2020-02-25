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
 * @author M1044400
 *
 */
public class RegisterPage extends BaseTest{
private static final Logger log = LogManager.getLogger(RegisterPage.class);	
	
	@FindBy(xpath = "//a[contains(text(),'REGISTER')]")
    private WebElement registerLink;
	
	@FindBy(xpath = "//input[@name='firstName']")
    public WebElement fName;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lName;
    
    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phone;
    
    @FindBy(xpath = "//input[@name='userName']")
    private WebElement email;
    
    @FindBy(xpath = "//input[@name='address1']")
    private WebElement address;
    
    @FindBy(xpath = "//input[@name='city']")
    private WebElement city;
    
    @FindBy(xpath = "//input[@name='state']")
    private WebElement state;
    
    @FindBy(xpath = "//input[@name='postalCode']")
    private WebElement postal;
    
    @FindBy(xpath = "//*[@name='country']")
    private WebElement country;
    
    @FindBy(xpath = "//input[@name='email']")
    private WebElement userName;
    
    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;
    
    @FindBy(xpath = "//input[@name='confirmPassword']")
    private WebElement confirmPassword;
    
    @FindBy(xpath = "//input[@name='register']")
    private WebElement register;
    
   
    
    @FindBy(xpath ="//table[@width='492']//tr[3]")
    private WebElement registrationDetails;
    
    
    
    public void clickOnRegisterLink(){
    	try {
    		Actions.clickElement(registerLink);
    	} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }

    public void enterFirstName(String setFName) {
    	try {
			Actions.insertValuesInATextField(fName, setFName);
		} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }
    public void enterLastName(String setLName) {
    	try {
			Actions.insertValuesInATextField(lName, setLName);
		} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }
    
    public void enterPhoneNumber(String phoneNumber) {
    	try {
			Actions.insertValuesInATextField(phone, phoneNumber);
		} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }
    
    public void enterEmail(String setEmail) {
    	try {
			Actions.insertValuesInATextField(email, setEmail);
		} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }
    
    public void enterAddress(String setaddress) {
    	try {
			Actions.insertValuesInATextField(address, setaddress);
		} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }
    
    public void enterCity(String setCity) {
    	try {
			Actions.insertValuesInATextField(city, setCity);
		} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }
    
    public void enterState(String setState) {
    	try {
			Actions.insertValuesInATextField(state, setState);
		} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }
    
    public void enterPostal(String setPostal) {
    	try {
			Actions.insertValuesInATextField(postal, setPostal);
		} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }
    
    public void enterCountry(String setCountry) {
    	try {
			Actions.insertValuesInATextField(country, setCountry);
		} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }
    
    public void enterUserName(String setUserName) {
    	try {
			Actions.insertValuesInATextField(userName, setUserName);
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
    
    public void enterConfirmPasswprd(String setConfirmPassword) {
    	try {
			Actions.insertValuesInATextField(confirmPassword, setConfirmPassword);
		} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }
    
    public void clickOnSubmitButton(){
    	try {
    		Actions.clickElement(register);
    	} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }
    
    
    public String getRegisteredDetails() {
    	try {
    		return Actions.getText(registrationDetails);
    	}catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
    			log.error("error occured!!");
    		}
		return null;
        }

    public static RegisterPage getRegisterPage(WebDriver driver){
    	return PageFactory.initElements(driver, RegisterPage.class);
    }
}
