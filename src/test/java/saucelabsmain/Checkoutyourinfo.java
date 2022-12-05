package saucelabsmain;

import Pageobjectmodels.Checkoutpo;
import Pageobjectmodels.Loginpagepo;
import Pageobjectmodels.Productspagepo;
import Pageobjectmodels.Yourscartpo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Checkoutyourinfo {
	public WebDriver driver;																					//Startup steps
	public Loginpagepo login;
	public Productspagepo prod;
	public Yourscartpo cart;
	public Checkoutpo check;

	@BeforeMethod
	public void open() throws InterruptedException {
		driver = new ChromeDriver();
		login = new Loginpagepo(driver);
		prod = new Productspagepo(driver);
		cart = new Yourscartpo(driver);
		check = new Checkoutpo(driver);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		login.setUsername("standard_user");
		login.setPassword("secret_sauce");
		login.setLoginbutton();
		prod.setAddtocart();
		prod.setYourscartbutton();
		cart.setCheckoutbutton();
		Thread.sleep(2000);
	}
	@AfterMethod																								//Final Steps
	public void close() {
		driver.quit();
	}
	@Test
	public void TC_037() {																					
		check.setFname("Louis");
		check.setLname("Ebi");
		check.setPincode("600001");
		check.setContinuebutton();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");	
	}
	@Test
	public void TC_038() {
		check.setLname("Ebi");
		check.setPincode("600001");
		check.setContinuebutton();
		check.setErrortext();
		Assert.assertEquals(check.setErrortext(), "Error: First Name is required");
	}
	@Test
	public void TC_039() {
		check.setFname("Louis");
		check.setPincode("600001");
		check.setContinuebutton();
		check.setErrortext();
		Assert.assertEquals(check.setErrortext(), "Error: Last Name is required");
	}
	@Test
	public void TC_040() {
		check.setFname("Louis");
		check.setLname("Ebi");
		check.setContinuebutton();
		check.setErrortext();
		Assert.assertEquals(check.setErrortext(), "Error: Postal Code is required");
	}
	@Test
	public void TC_041() {
		check.setContinuebutton();
		check.setErrortext();
		Assert.assertEquals(check.setErrortext(), "Error: First Name is required");
	}
	@Test
	public void TC_042() throws InterruptedException {
		check.setFname("Louis123");
		check.setLname("Ebi");
		check.setPincode("600001");
		check.setContinuebutton();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-one.html");
	}	
	@Test
	public void TC_043() throws InterruptedException {
		check.setFname("Louis");
		check.setLname("Ebi123");
		check.setPincode("600001");
		check.setContinuebutton();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-one.html");
	}
	@Test
	public void TC_044() throws InterruptedException {
		check.setFname("Louis");
		check.setLname("Ebi");
		check.setPincode("chennai");
		check.setContinuebutton();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-one.html");
	}
	@Test
	public void TC_045() throws InterruptedException {
		check.setFname("Louis");
		check.setLname("Ebi");
		check.setPincode("60000111");
		check.setContinuebutton();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-one.html");
	}
	@Test
	public void TC_046() {
		check.setCancel();
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/cart.html");
	}
	
	
}
