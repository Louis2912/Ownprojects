package saucelabsmain;

import Pageobjectmodels.Loginpagepo;
import Pageobjectmodels.Productdetailpagepo;
import Pageobjectmodels.Productspagepo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.PublicKey;

public class productdetailspage {
	public WebDriver driver;																						//Startup steps
	public Loginpagepo login;
	public Productspagepo prod;
	public Productdetailpagepo pdeatil;



	@BeforeMethod
	public void open() throws InterruptedException {
		driver = new ChromeDriver();
		login = new Loginpagepo(driver);
		prod = new Productspagepo(driver);
		pdeatil= new Productdetailpagepo(driver);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		login.setUsername("standard_user");
		login.setPassword("secret_sauce");
		login.setLoginbutton();
		pdeatil.setProductname();
		Thread.sleep(2000);
	}
	@AfterMethod																									//Final Steps
	public void close() {
		driver.quit();
	}
	
	@Test
	public void TC_016() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory-item.html?id=4");			//Fetched the current URL and compared with the expected URL. 																										
	}
	@Test
	public void TC_017() {
		pdeatil.setBacktoprod();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");                     //Fetched the current URL and compared with the expected URL. 																										
	}
	@Test
	public void TC_018() throws InterruptedException {
		pdeatil.setAddtocart();
		String nameondetailspage = driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText();	//Fetching the product name on product details page and storing
		Thread.sleep(2000);
		prod.setYourscartbutton();
		String nameonyourscart= driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();		//Fetching the product name on yourscart page
		Assert.assertEquals(nameonyourscart,nameondetailspage);                                                     //comparing the both names from different pages 																										
	}
	

}
