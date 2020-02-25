/**
 * 
 */
package mindtree.yorbit.mercury.testcases;

import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import mindtree.yorbit.mercury.base.BaseTest;
import mindtree.yorbit.mercury.pageobjects.BookFlightsPage;
import mindtree.yorbit.mercury.pageobjects.FindFlightsPage;
import mindtree.yorbit.mercury.pageobjects.LoginPage;
import mindtree.yorbit.mercury.pageobjects.SelectFlightsPage;
import mindtree.yorbit.mercury.util.ExcelUtilities;

/**
 * @author M1044400
 *
 */
public class RoundTripBookingTest extends BaseTest {
	private static final Logger log = LogManager.getLogger(LoginTest.class);


	@Test(priority = 1, dataProvider = "bookingData")
	public void roundTripBooking(String uName, String password, String noOfPassenger, String departingCity,
			String month, String departDate, String arrivingCity, String arrivalDate, String setFName, String setLName,
			String cardNumber, String address, String city, String state, String postal) {
		LoginPage loginPage = LoginPage.getLoginpage(getDriver());
		loginPage.enterUserName(uName);
		loginPage.enterPassword(password);
		loginPage.clickOnSignIN();
		logStatus(log, test, "info", "User logged-in successfully");

		FindFlightsPage findFlights = FindFlightsPage.getFindFlightsPage(getDriver());
		findFlights.selectPsgrs(noOfPassenger);
		findFlights.departFrom(departingCity);
		findFlights.departFromMonth(month);
		findFlights.departFromDate(departDate);
		findFlights.arrivingFrom(arrivingCity);
		findFlights.arrivingFromMonth(month);
		findFlights.arriveFromDate(arrivalDate);
		findFlights.clickOnContinue();
		logStatus(log, test, "info", "moved to flight selection page");

		SelectFlightsPage selectFlights = SelectFlightsPage.getSelectFlightsPage(getDriver());
		selectFlights.selectDepartureFlight();
		selectFlights.selectReturnFlight();
		selectFlights.clickOnContinueFlights();
		logStatus(log, test, "info", "moved to passenger details screen");

		BookFlightsPage bookFlights = BookFlightsPage.getBookFlightsPage(getDriver());
		bookFlights.enterFirstName(setFName);
		bookFlights.enterLastName(setLName);
		bookFlights.selectMeal();
		bookFlights.selectCardType();
		bookFlights.enterCardNumber(cardNumber);
		bookFlights.entercardFirstName(setFName);
		bookFlights.entercardLastName(setLName);
		bookFlights.selectCardExpiryMonth();
		bookFlights.selectCardExpiryYear();
		bookFlights.enterBAddress(address);
		bookFlights.enterBCity(city);
		bookFlights.enterBState(state);
		bookFlights.enterBPostal(postal);
		bookFlights.clickOnSecurePurchase();
		List<WebElement> myElements = driver.findElements(By.xpath("//td[@class='frame_header_info']"));
		String successMessage = myElements.get(0).getText();
		String ConfirmationNumber = successMessage.substring(0, 40);
		logStatus(log, test, "pass", "Congratulations your "+ ConfirmationNumber +" !!");
	}

	@DataProvider(name = "bookingData")
	public Object[][] getConfigData() {
		return ExcelUtilities.getDataFromSpreadSheet("Booking.xlsx", "RoundTrip");

	}

}
