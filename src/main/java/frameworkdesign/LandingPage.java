package frameworkdesign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// driver.findElement(By.xpath("//div[@class='header__center']//li[@class='user']")).click();
	// Login
	@FindBy(xpath = "//div[@class='header__center']//li[@class='user']")
	WebElement Prijava;

	// driver.findElement(By.id("email")).sendKeys("******");
	// email field
	@FindBy(id = "email")
	WebElement userEemail;

	// driver.findElement(By.id("password")).sendKeys("********");
	// password field
	@FindBy(id = "password")
	WebElement passwordElement;

	// driver.findElement(By.id("loginSubmit")).click();
	// login button
	@FindBy(id = "loginSubmit")
	WebElement login;

	public ProductCalalogue loginApplication(String email, String password) throws Exception {
		Prijava.click();
		waitForWebElementToAppear(userEemail);
		userEemail.sendKeys(email);
		passwordElement.sendKeys(password);
		login.click();

		try {

			// some IOoperations

		} catch (Exception e) {
			throw e;
			/* handle some possible errors of of the IOoperations */
		}

		ProductCalalogue productcatalogue = new ProductCalalogue(driver);
		return productcatalogue;
	}

	// hardcoded - should be kept somewhere else
	public void goTo() {
		driver.get("https://gigatron.rs/");
	}

}
