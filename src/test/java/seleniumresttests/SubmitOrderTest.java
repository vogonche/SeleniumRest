package seleniumresttests;

import org.testng.annotations.Test;

import frameworkdesign.CheckOutPages;
import frameworkdesign.GetTestData;
import frameworkdesign.ProductCalalogue;
import testcomponents.BaseTest;

public class SubmitOrderTest extends BaseTest {

	@Test(groups = { "Submit Order" })
	public void SubmitOrder() throws Exception {

		// get test data
		GetTestData testData = new GetTestData();
		String[][] cred = testData.returnCredentials();
		String username = cred[0][0];
		String passwords = cred[0][1];
		String[][] items = testData.getItems();
		String firstItem = items[0][0];
		String secondItem = items[0][1];

		// test
		ProductCalalogue productcatalogue = landingPage.loginApplication(username, passwords);
		productcatalogue.addProductToChart(firstItem);
		productcatalogue.ClearSearh();
		productcatalogue.addProductToChart(secondItem);
		productcatalogue.DeleteFirstProductFromChart();
		CheckOutPages checkOutPage = productcatalogue.goToCheckOutPage();
		checkOutPage.goToCheckoutPages();

	}

}
