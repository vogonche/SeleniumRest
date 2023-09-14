package testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import frameworkdesign.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landingPage;

	public WebDriver initializeDriver() throws IOException {

		// properties class
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\GlobalData.properties");
		prop.load(fis);

		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");
		if (browserName.contains("chrome")) {

			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			// Firefox
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			// Edge
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApplication() throws IOException {
		driver = initializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		// comented out just to show last page of execution
		// driver.quit();
	}

	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {

		double num = Math.random();

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			// String path = System.getProperty("user.dir")+"\\reports\\index.html";
			File file = new File(System.getProperty("user.dir") + "\\reports\\" + testCaseName + num + ".png");
			FileUtils.copyFile(source, file);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return System.getProperty("user.dir") + "\\reports\\" + testCaseName + num + ".png";

	}

}