/**
 * 
 */
package mindtree.yorbit.mercury.util;

import java.util.NoSuchElementException;

import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import mindtree.yorbit.mercury.base.BaseTest;
import mindtree.yorbit.mercury.exceptions.ElementNotClickable;
import mindtree.yorbit.mercury.exceptions.ElementNotPresentException;
import mindtree.yorbit.mercury.exceptions.LocatorNotFound;

/**
 * @author M1044400
 *
 */
public class Actions extends BaseTest{

	public static String getText(final WebElement elementTextToGet) throws LocatorNotFound, ElementNotClickable, ElementNotPresentException{
		try  {
		return elementTextToGet.getText();
		}catch (NoSuchElementException | TimeoutException e ) {
			throw new LocatorNotFound("Cannot Find Element" + e.getMessage(),elementTextToGet );
			
		} catch (ElementNotSelectableException e) {
			throw new ElementNotClickable("Unable to find element" + e.getMessage(),elementTextToGet);
		}

		catch (StaleElementReferenceException e) {
			throw new ElementNotPresentException("element is no longer appearing on the DOM page" + e.getMessage(),elementTextToGet);
		}
	}
	
	public static void clickElement(final WebElement elementToClick)
			throws LocatorNotFound, ElementNotClickable, ElementNotPresentException {
		try {
			elementToClick.click();
		} catch (NoSuchElementException | TimeoutException e ) {
			throw new LocatorNotFound("Cannot Find Element" + e.getMessage(),elementToClick );
		} catch (ElementNotSelectableException e) {
			throw new ElementNotClickable("Unable to find element" + e.getMessage(),elementToClick);
		}

		catch (StaleElementReferenceException e) {
			throw new ElementNotPresentException("element is no longer appearing on the DOM page" + e.getMessage(),elementToClick);
		}

	}
	
	public static void insertValuesInATextField(WebElement elementToTypeValuesInto, String valueToType) throws LocatorNotFound, ElementNotClickable, ElementNotPresentException {
		try {
		elementToTypeValuesInto.sendKeys(valueToType);
		}catch (NoSuchElementException | TimeoutException e ) {
			throw new LocatorNotFound("Cannot Find Element" + e.getMessage(),elementToTypeValuesInto );
		} catch (ElementNotSelectableException e) {
			throw new ElementNotClickable("Unable to find element" + e.getMessage(),elementToTypeValuesInto);
		}

		catch (StaleElementReferenceException e) {
			throw new ElementNotPresentException("element is no longer appearing on the DOM page" + e.getMessage(),elementToTypeValuesInto);
		}
	}
	
	public static void clearValuesInATextBox(final WebElement elementValueToClear) throws InterruptedException, LocatorNotFound, ElementNotClickable, ElementNotPresentException {
		try {
		elementValueToClear.clear();
		}catch (NoSuchElementException  | TimeoutException e ) {
			throw new LocatorNotFound("Cannot Find Element" + e.getMessage(),elementValueToClear );
		} catch (ElementNotSelectableException e) {
			throw new ElementNotClickable("Unable to find element" + e.getMessage(),elementValueToClear);
		}

		catch (StaleElementReferenceException e) {
			throw new ElementNotPresentException("element is no longer appearing on the DOM page" + e.getMessage(),elementValueToClear);
		}
	}
	public static void selectDropDownByValueAppearing(final WebElement dropDownList, final String valueToSelect) throws LocatorNotFound, ElementNotClickable, ElementNotPresentException  {
		try {	
			Select element = new Select(dropDownList);
			element.selectByVisibleText(valueToSelect);
		}catch (NoSuchElementException | TimeoutException e ) {
			throw new LocatorNotFound("Cannot Find Element" + e.getMessage(),dropDownList );
		} catch (ElementNotSelectableException e ) {
			throw new ElementNotClickable("Unable to find element" + e.getMessage(),dropDownList);
		}
		catch (StaleElementReferenceException e) {
			throw new ElementNotPresentException("element is no longer appearing on the DOM page" + e.getMessage(),dropDownList);
		}
	}
	public static void selectDropDownMenuByIndexValue(WebElement dropDownList,  int valueToSelect) throws InterruptedException, LocatorNotFound, ElementNotClickable, ElementNotPresentException {
		try {	
			Select element = new Select(dropDownList);
			element.selectByIndex(valueToSelect);
		}catch (NoSuchElementException | TimeoutException e ) {
			throw new LocatorNotFound("Cannot Find Element" + e.getMessage(),dropDownList );
		} catch (ElementNotSelectableException e) {
			throw new ElementNotClickable("Unable to find element" + e.getMessage(),dropDownList);
		}

		catch (StaleElementReferenceException e) {
			throw new ElementNotPresentException("element is no longer appearing on the DOM page" + e.getMessage(),dropDownList);
		}
	}
	public static void waitForElementToEnable(final WebDriver driver, final long waitTime,
			WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
