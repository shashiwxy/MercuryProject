package mindtree.yorbit.mercury.exceptions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class ElementNotClickable extends Exception
{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = LogManager.getLogger(Exception.class);
public ElementNotClickable(String s, WebElement element) {
	super(s);
	log.error("The element to click in not enabled: " + element);
}
}
