package mindtree.yorbit.mercury.base;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import mindtree.yorbit.mercury.util.ExtentManager;
import mindtree.yorbit.mercury.util.TestConstants;

/**
 * @author M1044400
 *
 */
public class BaseTest {

	public WebDriver driver;
	public static Properties prop;
	protected ExtentTest test;
	public ExtentReports report = ExtentManager.getInstance();
	protected WebDriverWait wait;

	protected static final Logger log = LogManager.getLogger(BaseTest.class);
/*
 * This method will execute before every test class
 * This method initialize the driver after reading the property.
 */
	@BeforeClass
	public void driverInitialization() {
		readConfigProperties();
		setReport(ExtentManager.getInstance());
		String browserName = prop.getProperty("browser");

		if (browserName.equals("Chrome")) {
			driver = initializeChrome();
			setDriver(driver);
		} else if (browserName.equals("FireFox")) {
			driver = initializeFirefox();
			setDriver(driver);
		} else {
			log.error("Unrecognized browserName specified");
			throw new RuntimeException("Unrecognized browserName specified: " + browserName);
		}
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(TestConstants.GLOBAL_IMPLICIT_TIME, TimeUnit.SECONDS);
		getDriver().get( prop.getProperty("applicationUrl"));
	}
	
	@BeforeMethod
	public void getMethodName(Method method) {
		System.out.println("Test name: " + method.getName());
		test = getReport().startTest(method.getName());
	}
	
	
	@AfterClass
	public void flush() {
		report.endTest(test);
		report.flush();
		getDriver().close();
	}
	
	
	/*
	 * This method will read the data from property file
	 */
	public static void readConfigProperties() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + TestConstants.CONFIG_PROPERTIES_PATH);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
/*
 * This method will initialize the chromeDriver
 * path of chrome driver is given in TestConstants class
 */
	public static WebDriver initializeChrome() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + TestConstants.CHROME_DRIVER_PATH);
		return new ChromeDriver();
	}
	/*
	 * This method will initialize the firefoxDriver
	 * path of firefox driver is given in TestConstants class
	 */
	private static WebDriver initializeFirefox() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + TestConstants.GECKO_DRIVER_PATH);
		return new FirefoxDriver();
	}
	/*
	 * This method will log the status of every steps included 
	 * in our testcase.
	 * It logs in the extent as well as log4j
	 */
	public void logStatus(final Logger log, final ExtentTest test, final String status, final Object message) {

		if (status.equalsIgnoreCase("info")) {
			log.info(message);
			test.log(LogStatus.INFO, message.toString());
		} else if (status.equalsIgnoreCase("error")) {
			log.info(message);
			test.log(LogStatus.ERROR, message.toString());
			takeScreenShot(test);
		} else if (status.equalsIgnoreCase("fail")) {
			log.info(message);
			test.log(LogStatus.FAIL, message.toString());
			takeScreenShot(test);
		}  else if (status.equalsIgnoreCase("pass")) {
			log.info(message);
			test.log(LogStatus.PASS, message.toString());
		} else {
			log.info("Invalid log input provided");
			test.log(LogStatus.INFO, "Invalid log input provided");
		}

	}
	/*
	 * This method will take the screenshot
	 */
	public void takeScreenShot(final ExtentTest test) {
		Date d = new Date();
		String fileName = d.toString().replace(" ", "_").replace(":", "_");

		String filePath = System.getProperty("user.dir") + TestConstants.SCREENSHOTS_FOLDER + fileName
				+ ".jpg";
		File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(filePath));
		} catch (Exception e) {
			log.error("Test failed due to IOException");
			log.error("IOException " + e.getMessage());
		}
		test.log(LogStatus.INFO, test.addScreenCapture(filePath));
	}
	
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public ExtentReports getReport() {
		return report;
	}
	public void setReport(ExtentReports report) {
		this.report = report;
	}
	
}
