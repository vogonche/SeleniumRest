package seleniumresttests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {

		// Stand alone basic test - straight forward and rough which will evolve in real
		// structured test

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://gigatron.rs/");
		driver.findElement(By.xpath("//div[@class='header__center']//li[@class='user']")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("email")).sendKeys("unesi email");
		driver.findElement(By.id("password")).sendKeys("unesi password");
		driver.findElement(By.id("loginSubmit")).click();
		driver.findElement(By
				.xpath("//div[@id='header__center__searchbox']//div//input[@placeholder='Unesite pojam za pretragu']"))
				.sendKeys("logitech g935", Keys.RETURN);
		Thread.sleep(5000);
		// driver.findElement(By.xpath("//img[@alt='LOGITECH gejmerske slušalice G935
		// Wireless (Crna) 981 000744']")).click();
		driver.findElements(By.className("item__image")).get(0).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class='product-page__add-to-cart-btn']")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(".white")).click();
		driver.findElement(By
				.xpath("//div[@id='header__center__searchbox']//div//input[@placeholder='Unesite pojam za pretragu']"))
				.clear();
		driver.findElement(By
				.xpath("//div[@id='header__center__searchbox']//div//input[@placeholder='Unesite pojam za pretragu']"))
				.sendKeys("EDIFIER R2000DB", Keys.RETURN);
		Thread.sleep(5000);
		driver.findElements(By.className("item__image")).get(0).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class='product-page__add-to-cart-btn']")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(".btn-order")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='containerSelectorFocus']/div[1]/div/div/div[1]/div/div[5]")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(".bundle-order-button.right")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(".bundle-order-button.next-button.right")).click();
		Thread.sleep(5000);
		// dve mogucnosti
		// driver.findElement(By.xpath("//h3[contains(text(),'Plaćanje prilikom
		// preuzimanja')]")).click();
		driver.findElement(
				By.cssSelector("div[class='select-option__new'] div:nth-child(1) div:nth-child(1) h3:nth-child(1)"))
				.click();
		Thread.sleep(5000);
		driver.findElement(By.id("shippbtn")).click();

		System.out.println("Done");

	}

}
