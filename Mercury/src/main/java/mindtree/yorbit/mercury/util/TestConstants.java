package mindtree.yorbit.mercury.util;

import java.io.File;

public class TestConstants {
	public static final String MERCURY_TEST_RESOURCES_FOLDER = File.separator + "src" + File.separator + "test"
			+ File.separator + "resources" + File.separator;
	
	public static final String MERCURY_MAIN_RESOURCES_FOLDER = File.separator + "src" + File.separator + "main"
			+ File.separator + "resources" + File.separator;
	
	public static final String REPORT_FILE_PATH = MERCURY_TEST_RESOURCES_FOLDER+File.separator+"reports"+ File.separator;
	
	public static final String SCREENSHOTS_FOLDER=MERCURY_TEST_RESOURCES_FOLDER+File.separator+"screenshots"+ File.separator;
	
	public static final String CONFIG_PROPERTIES_PATH = MERCURY_MAIN_RESOURCES_FOLDER + "Constants.properties";
	
	public static final String MERCURY_TEST_DATA_FOLDER = MERCURY_TEST_RESOURCES_FOLDER
	            + File.separator + "data" + File.separator;
	
	public static final String CHROME_DRIVER_PATH = MERCURY_TEST_RESOURCES_FOLDER + "drivers" + File.separator
			+ "chromedriver.exe";
	
	public static final String GECKO_DRIVER_PATH = MERCURY_TEST_RESOURCES_FOLDER + "drivers" + File.separator
			+ "geckodriver.exe";
	
	public static final int GLOBAL_IMPLICIT_TIME=30;

	public static final String ENVIRONMENT = "QA";
}
