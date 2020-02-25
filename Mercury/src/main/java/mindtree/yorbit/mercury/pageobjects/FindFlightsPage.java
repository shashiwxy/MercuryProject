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



public class FindFlightsPage extends BaseTest{
	private static final Logger log = LogManager.getLogger(Exception.class);
	
	
	@FindBy(xpath = "//*[@name='passCount']")
    private WebElement passengersDropdown;

    @FindBy(xpath = "//input[@value='roundtrip']")
	public  WebElement twoWayTrip;
    
    @FindBy(xpath = "//*[@name='fromPort']")
    private WebElement departingFrom;

    @FindBy(xpath = "//*[@name='fromMonth']")
    private WebElement departingFromPlace;
    
    @FindBy(xpath = "//*[@name='fromDay']")
    private WebElement departingFromDate;

    @FindBy(xpath = "//*[@name='toPort']")
    private WebElement arrivingFrom;

    @FindBy(xpath = "//*[@name='toMonth']")
    private WebElement arrivingFromPlace;
    
    @FindBy(xpath = "//*[@name='toDay']")
    private WebElement arrivingFromDate;
    
    @FindBy(xpath = "//*[@value='Business']")
    private WebElement serviceClass;

    @FindBy(xpath = "//*[@name='airline']")
    private WebElement airlinesDropdown;
    
    @FindBy(xpath = "//*[@name='findFlights']")
    public WebElement findFlights;
    
    
    public void selectPsgrs(String noOfPassenger) {
    	try {
			try {
				Actions.selectDropDownMenuByIndexValue(passengersDropdown, 2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }
    public void departFrom(String departingCity) {
    	try {
			Actions.selectDropDownByValueAppearing(departingFrom, departingCity);
		} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }
    public void departFromMonth(String month) {
    	try {
			Actions.selectDropDownByValueAppearing(departingFromPlace, month);
		} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }
    public void departFromDate(String date) {
    	try {
			Actions.selectDropDownByValueAppearing(departingFromDate, date);
		} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }
    public void arrivingFrom(String arrivingCity) {
    	try {
			Actions.selectDropDownByValueAppearing(arrivingFrom, arrivingCity);
		} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }
    public void arrivingFromMonth(String month) {
    	try {
			Actions.selectDropDownByValueAppearing(arrivingFromPlace, month);
		} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }
    public void arriveFromDate(String date) {
    	try {
			Actions.selectDropDownByValueAppearing(arrivingFromDate, date);
		} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }
    
    public void airline(String airlineType) {
    	try {
			Actions.selectDropDownByValueAppearing(airlinesDropdown, airlineType);
		} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }
    public void clickOnContinue(){
    	try {
    		Actions.clickElement(findFlights);
    	} catch (LocatorNotFound | ElementNotClickable | ElementNotPresentException e) {
			log.error("error occured!!");
		}
    }
    public static FindFlightsPage getFindFlightsPage(WebDriver driver){
    	return PageFactory.initElements(driver, FindFlightsPage.class);
    }
}
