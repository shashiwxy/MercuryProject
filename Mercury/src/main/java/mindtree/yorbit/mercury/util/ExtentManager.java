/**
 * 
 */
package mindtree.yorbit.mercury.util;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

/**
 * @author M1044400
 *
 */
public class ExtentManager {
	private static ExtentReports extent;
	private ExtentManager() {

	}

	public static synchronized ExtentReports getInstance() {
		if (extent == null) {
			String fileName = "Automatiom_Report";
			String reportFileNamePath = System.getProperty("user.dir") + TestConstants.REPORT_FILE_PATH + fileName
					+ ".html";
			extent = new ExtentReports(reportFileNamePath, true);
			extent.loadConfig(new File(System.getProperty("user.dir") + TestConstants.MERCURY_MAIN_RESOURCES_FOLDER
					+ "extent-config.xml"));
			extent.addSystemInfo("Environment", TestConstants.ENVIRONMENT);
			extent.addSystemInfo("Browser", "chrome");
			extent.addSystemInfo("Application URL", "http://newtours.demoaut.com");
		}
		return extent;
	}
}
