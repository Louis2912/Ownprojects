package saucelabsmain;

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

public class Yourcart {
	public WebDriver driver;																					//Startup steps
	public Loginpagepo login;
	public Productspagepo prod;
	public Yourscartpo cart;

	@BeforeMethod
	public void open() throws InterruptedException {
		driver = new ChromeDriver();
		login = new Loginpagepo(driver);
		prod = new Productspagepo(driver);
		cart = new Yourscartpo(driver);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		login.setUsername("standard_user");
		login.setPassword("secret_sauce");
		login.setLoginbutton();
		prod.setAddtocart();
		prod.setYourscartbutton();
	}
	@AfterMethod																								//Final Steps
	public void close() {
		driver.quit();
	}
	
	@Test
	public void TC_032() {
		cart.setQuantity();
		Assert.assertEquals(cart.setQuantity(), false);	//checking the box selected or not
	}
	
	@Test
	public void TC_033() {
		cart.setContinueshopping();
		driver.getCurrentUrl();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");				//Checking the page navigated
	}
	
	@Test
	public void TC_034() {
		cart.setRemoveprod();										//Check the product present or not
		try {
			cart.setProdnameoncart();
		}catch (Exception error) {
			error.getCause();
			Assert.assertNull(error.getCause());																//catch the null exception and validate
		}
	}
	@Test
	public void TC_035() {
		cart.setCheckoutbutton();															//Checkout page
		driver.getCurrentUrl();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html");
	}
	@Test
	public void TC_036() {
		cart.setRemoveprod();										//Without product page checkout
		cart.setCheckoutbutton();
		driver.getCurrentUrl();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");						//Check the page changed or not
	}
	
}
