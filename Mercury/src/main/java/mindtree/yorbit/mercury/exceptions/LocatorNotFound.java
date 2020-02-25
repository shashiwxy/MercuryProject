package mindtree.yorbit.mercury.exceptions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class LocatorNotFound extends Exception
{
	private static final long serialVersionUID = 1L;
	private static final Logger log = LogManager.getLogger(Exception.class);
	
	public LocatorNotFound(String s, WebElement element) {
		super(s);
		log.error("Unable to find the specified locator: " + element);
		
	}

}
