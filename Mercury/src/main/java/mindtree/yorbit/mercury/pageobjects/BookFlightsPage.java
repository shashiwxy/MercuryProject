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



public class BookFlightsPage extends BaseTest{
	private static final Logger log = LogManager.getLogger(BookFlightsPage.class);	
	
	@FindBy(xpath = "//input[@name='passFirst0']")
    public WebElement fName;

    @FindBy(xpath = "//input[@name='passLast0']")
    private WebElement lName;
    
    @FindBy(xpath = "//*[@name='pass.0.meal']")
    private WebElement mealDropdown;

    @FindBy(xpath = "//*[@name='creditCard']")
    private WebElement cardTypeDropdown;

    @FindBy(xpath = "//input[@name='creditnumber']")
    public WebElement cardNumber;
    
    @FindBy(xpath = "//*[@name='cc_exp_dt_mn']")
    private WebElement cardExpiryMonth;

    @FindBy(xpath = "//*[@name='cc_exp_dt_yr']")
    public WebElement cardExpiryYear;
    
    @FindBy(xpath = "//input[@name='cc_frst_name']")
    private WebElement cardFirstName;

    @FindBy(xpath = "//input[@name='cc_mid_name']")
    public WebElement cardMiddleName;
    
    @FindBy(xpath = "//input[@name='cc_last_name']")
    private WebElement cardLastName;

    @FindBy(xpath = "//input[@name='billAddress1']")
    public WebElement billingAddress;
    
    @FindBy(xpath = "//input[@name='billCity']")
    private WebElement billingCity;

    @FindBy(xpath = "//input[@name='billState']")
    public WebElement billingState;
    
    @FindBy(xpath = "//input[@name='billZip']")
    private WebElement billingPostal;

    @FindBy(xpath = "//*[@name='billCountry']")
    public WebElement billingCountry;
    
    @FindBy(xpath = "//input[@name='delAddress1']")
    public WebElement deliveryAddress;
    
    @FindBy(xpath = "//input[@name='delCity']")
    private WebElement deliveryCity;

    @FindBy(xpath = "//input[@name='delState']")
    public WebElement deliveryState;
    
    @FindBy(xpath = "//input[@name='delZip']")
    private WebElement deliveryPostal;

    @FindBy(xpath = "//*[@name='delCountry']")
    public WebElement deliveryCountry;
    
    @FindBy(xpath = "//input[@name='buyFlights']")
    public WebElement securePayment;
    
    public void selectCardExpiryMonth(){
    	try {
    	Actions.selectDropDownMenuByIndexValue(cardExpiryMonth, 1); 
    	} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException | InterruptedException e) {
			log.error("error occured!!");
		}
    }
    public void selectCardExpiryYear() {
    	try {
    	Actions.selectDropDownMenuByIndexValue(cardExpiryYear, 1); 
    } catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException | InterruptedException e) {
		log.error("error occured!!");
	}
    }
    public void selectDeliveryCountry(String valueToSelect) {
    	try {
			Actions.selectDropDownByValueAppearing(deliveryCountry, valueToSelect);
		} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    	
    }
    public void selectBillingCountry(String valueToSelect) {
    	try {
    	Actions.selectDropDownByValueAppearing(billingCountry, valueToSelect);
    	} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }
    	
    public void entercardFirstName(String setcardFName) {
    	try {
			Actions.insertValuesInATextField(cardFirstName, setcardFName);
		} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }
    public void entercardMiddleName(String setcardMName) {
    	try {
			Actions.insertValuesInATextField(cardFirstName, setcardMName);
		} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }
    
    public void entercardLastName(String setcardLName) {
    	try {
			Actions.insertValuesInATextField(cardFirstName, setcardLName);
		} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }
    
    public void enterBAddress(String setBAddress) {
    	try {
    		Actions.clearValuesInATextBox(billingAddress);
    		Actions.insertValuesInATextField(billingAddress, setBAddress);
		} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException | InterruptedException e) {
			log.error("error occured!!");
		}
    }
    public void enterBCity(String setBCity) {
    	try {
    		Actions.clearValuesInATextBox(billingCity);
    		Actions.insertValuesInATextField(billingCity, setBCity);
		} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException | InterruptedException e) {
			log.error("error occured!!");
		}
    }
    
    public void enterBState(String setBState) {
    	try {
    		Actions.clearValuesInATextBox(billingState);
    		Actions.insertValuesInATextField(billingState, setBState);
		} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException | InterruptedException e) {
			log.error("error occured!!");
		}
    }
    public void enterBPostal(String setBPostal) {
    	try {
    		Actions.clearValuesInATextBox(billingPostal);
    		Actions.insertValuesInATextField(billingPostal, setBPostal);
		} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException | InterruptedException e) {
			log.error("error occured!!");
		}
    }
    
    public void enterDAddress(String setDAddress) {
    	try {
    		Actions.clearValuesInATextBox(deliveryAddress);
    		Actions.insertValuesInATextField(deliveryAddress, setDAddress);
		} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException | InterruptedException e) {
			log.error("error occured!!");
		}
    }
    public void enterDCity(String setDCity) {
    	try {
    		Actions.clearValuesInATextBox(deliveryCity);
    		Actions.insertValuesInATextField(deliveryCity, setDCity);
		} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException | InterruptedException e) {
			log.error("error occured!!");
		}
    }
    
    public void enterDState(String setDState) {
    	try {
    		Actions.clearValuesInATextBox(deliveryState);
    		Actions.insertValuesInATextField(deliveryState, setDState);
		} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException | InterruptedException e) {
			log.error("error occured!!");
		}
    }
    public void enterDPostal(String setDPostal) {
    	try {
    		Actions.clearValuesInATextBox(deliveryPostal);
    		Actions.insertValuesInATextField(deliveryPostal, setDPostal);
		} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException | InterruptedException e) {
			log.error("error occured!!");
		}
    }
    
    public void selectMeal() {
    	try {
        	Actions.selectDropDownMenuByIndexValue(mealDropdown, 2); 
        } catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException | InterruptedException e) {
    		log.error("error occured!!");
    	}
    	
    }
    public void selectCardType() {
    	try {
        	Actions.selectDropDownMenuByIndexValue(cardTypeDropdown, 2); 
        } catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException | InterruptedException e) {
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
    
    public void enterCardNumber(String setCardNo) {
    	try {
			Actions.insertValuesInATextField(cardNumber, setCardNo);
		} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }
    
    public void clickOnSecurePurchase(){
    	try {
    		Actions.clickElement(securePayment);
    	} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }
    
    public static BookFlightsPage getBookFlightsPage(WebDriver driver){
    	return PageFactory.initElements(driver, BookFlightsPage.class);
    }
}
