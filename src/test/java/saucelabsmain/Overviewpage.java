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

public class Overviewpage {
	public WebDriver driver;																						//Startup steps
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
		Thread.sleep(2000);
	}
	@AfterMethod																									//Final Steps
	public void close() {
		driver.quit();
	}
	@Test
	public void TC_047() throws InterruptedException {
		String beforeqty= driver.findElement(By.xpath("//div[text()='1']")).getText();								//Fetching and saving the product details on cart page
		String beforename= driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
		String beforedescription= driver.findElement(By.xpath("//div[@class='inventory_item_desc']")).getText(); 
		String beforeprice= driver.findElement(By.xpath("//div[text()='29.99']")).getText();
		cart.setCheckoutbutton();
		check.setFname("Louis");
		check.setLname("Ebi");
		check.setPincode("600001");
		check.setContinuebutton();
		Thread.sleep(2000);
		String afterqty= driver.findElement(By.xpath("//div[@class='cart_quantity']")).getText();
		String aftername= driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
		String afterdescription= driver.findElement(By.xpath("//div[@class='inventory_item_desc']")).getText();
		String afterprice= driver.findElement(By.xpath("//div[@class='inventory_item_price']")).getText();
		Assert.assertEquals(afterqty, beforeqty);																	//Fetching and saving the product details on overview page
		Assert.assertEquals(aftername, beforename);
		Assert.assertEquals(afterdescription, beforedescription);
		Assert.assertEquals(afterprice, beforeprice);	
		
	}
	

}
