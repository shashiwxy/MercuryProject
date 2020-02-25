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



public class SelectFlightsPage extends BaseTest{
	private static final Logger log = LogManager.getLogger(Exception.class);	
	
	@FindBy(xpath = "//input[@name='outFlight' and contains(@value,'Unified Airlines')]")
	public WebElement departureFlight;

    @FindBy(xpath = "//input[@name='inFlight' and contains(@value,'Unified Airlines')]")
    private WebElement returnFlight;
    
    @FindBy(xpath = "//input[@name='reserveFlights']")
    private WebElement continueButton;

    public void selectDepartureFlight(){
    	try {
    		Actions.clickElement(departureFlight);
    	} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }
    
    public void selectReturnFlight(){
    	try {
    		Actions.clickElement(returnFlight);
    	} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }
    
    public void clickOnContinueFlights(){
    	try {
    		Actions.clickElement(continueButton);
    	} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    	
    }
    public static SelectFlightsPage getSelectFlightsPage(WebDriver driver){
    	return PageFactory.initElements(driver, SelectFlightsPage.class);
    }
}
