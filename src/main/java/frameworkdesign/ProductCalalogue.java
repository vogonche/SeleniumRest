package frameworkdesign;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.AbstractComponent;

public class ProductCalalogue extends AbstractComponent {

	WebDriver driver;

	public ProductCalalogue(WebDriver driver) {
		// initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Page factory
	// driver.findElement(By.xpath("//div[@class='header__center']//li[@class='user']")).click();
	// search field
	@FindBy(xpath = "//div[@id='header__center__searchbox']//div//input[@placeholder='Unesite pojam za pretragu']")
	WebElement searchProduct;

	// driver.findElements(By.className("item__image")).get(0).click();
	// returned product
	@FindBy(className = "item__image")
	WebElement clickOnProduct;

	// driver.findElement(By.xpath("//button[@class='product-page__add-to-cart-btn']")).click();
	@FindBy(xpath = "//button[@class='product-page__add-to-cart-btn']")
	// button add to chart
	WebElement addToChart;

	// driver.findElement(By.cssSelector(".white")).click();
	@FindBy(css = ".white")
	// continue shopping button
	WebElement continueShopping;

	// driver.findElement(By.cssSelector(".btn-order")).click();
	// going to chart
	@FindBy(css = ".btn-order")
	WebElement goToChart;

	// driver.findElement(By.xpath("//div[@class='cart-items']//div[1]//div[1]//div[5]")).click();
	// @FindBy(css = "//div[@class='cart-items']//div[1]//div[1]//div[5]")
	// first item in chart
	@FindBy(css = ".remove-item")
	WebElement deleteFirstItemInChart;

	// driver.findElement(By.cssSelector(".bundle-order-button.right")).click();
	// checkout
	@FindBy(css = ".bundle-order-button.right")
	WebElement checkout;

	// hidden element preventing click on other elements
	@FindBy(className = "cart-bussy")
	private WebElement cartbussy;

	public void addProductToChart(String productName) throws InterruptedException {
		searchProduct.sendKeys(productName, Keys.ENTER);
		Thread.sleep(1000);
		waitForWebElementToAppear(clickOnProduct);
		waitForWebElementToBeClickable(clickOnProduct);
		clickOnProduct.click();
		waitForWebElementToAppear(addToChart);
		waitForWebElementToBeClickable(addToChart);
		addToChart.click();
	}

	public void ClearSearh() {
		waitForWebElementToAppear(continueShopping);
		continueShopping.click();
		waitForWebElementToAppear(searchProduct);
		searchProduct.clear();
	}

	public void DeleteFirstProductFromChart() throws InterruptedException {

		waitForWebElementToAppear(goToChart);
		waitForWebElementToBeClickable(goToChart);
		goToChart.click();

		waitForElementToDisaper(cartbussy);
		waitForWebElementToAppear(deleteFirstItemInChart);
		waitForWebElementToBeClickable(deleteFirstItemInChart);
		deleteFirstItemInChart.click();

	}

	public CheckOutPages goToCheckOutPage() {
		waitForElementToDisaper(cartbussy);
		waitForWebElementToBeClickable(checkout);
		checkout.click();
		CheckOutPages CheckOutPages = new CheckOutPages(driver);
		return CheckOutPages;
	}

	public CheckOutPagesThreads goToCheckOutPageThreads() {
		waitForElementToDisaper(cartbussy);
		waitForWebElementToBeClickable(checkout);
		checkout.click();
		CheckOutPagesThreads CheckOutPages = new CheckOutPagesThreads(driver);
		return CheckOutPages;
	}

}
