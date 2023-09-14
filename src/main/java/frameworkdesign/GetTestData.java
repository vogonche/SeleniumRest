package frameworkdesign;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetTestData {

	// user credentials - read from property file
	public String[][] returnCredentials() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\GlobalData.properties");
		prop.load(fis);
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		String[][] credentials = { { username, password } };
		return credentials;

	}

	// Items to be added - read from property file
	public String[][] getItems() throws InterruptedException, IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\GlobalData.properties");
		prop.load(fis);
		String firstItem = prop.getProperty("firstItem");
		String secondItem = prop.getProperty("secondItem");
		String[][] items = { { firstItem, secondItem } };
		return items;

	}

}
