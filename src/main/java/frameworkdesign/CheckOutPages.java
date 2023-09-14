package frameworkdesign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.AbstractComponent;

public class CheckOutPages extends AbstractComponent {

	WebDriver driver;

	public CheckOutPages(WebDriver driver) {
		// initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// driver.findElement(By.cssSelector(".bundle-order-button.next-button.right")).click();
	@FindBy(css = ".bundle-order-button.next-button.right")
	WebElement continueButton;

	// driver.findElement(By.cssSelector("div[class='select-option__new']
	// div:nth-child(1) div:nth-child(1) h3:nth-child(1)")).click();
	// payment method
	@FindBy(xpath = "//h3[contains(text(),'Plaćanje prilikom preuzimanja')]")
	WebElement paymentMethod;

	// driver.findElement(By.id("shippbtn")).click();
	@FindBy(id = "shippbtn")
	WebElement continueToSubmit;

	// input[@type='checkbox']
	// agree checkbox on last page
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement agreeCheckbox;

	// Additional notes on last page
	@FindBy(className = "wide-input")
	WebElement additionalNotes;

	// invisible element - not clickable error if not used
	@FindBy(className = "cart-bussy")
	private WebElement cartbussy;

	public CheckOutPages goToCheckoutPages() throws InterruptedException {

		Thread.sleep(1500);

		waitForElementToDisaper(cartbussy);
		waitForWebElementToBeClickable(continueButton);
		continueButton.click();
		
		waitForElementToDisaper(cartbussy);
		waitForWebElementToBeClickable(paymentMethod);
		paymentMethod.click();

		waitForElementToDisaper(cartbussy);
		waitForWebElementToBeClickable(continueToSubmit);
		continueToSubmit.click();

		waitForElementToDisaper(cartbussy);
		waitForWebElementToBeClickable(agreeCheckbox);
		agreeCheckbox.click();

		additionalNotes.sendKeys("Homework");
		return new CheckOutPages(driver);

	}

}
