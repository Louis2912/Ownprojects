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

public class Completepage {
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
		cart.setCheckoutbutton();
		check.setFname("Louis");
		check.setLname("Ebi");
		check.setPincode("600001");
		check.setContinuebutton();
		driver.findElement(By.id("finish")).click();
	}
	@AfterMethod																									//Final Steps
	public void close() {
		driver.quit();
	}
	@Test
	public void TC_048() {
		String finalmsg = driver.findElement(By.xpath("//h2[@class='complete-header']")).getText();
		Assert.assertEquals(finalmsg, "THANK YOU FOR YOUR ORDER");
	}
	@Test
	public void TC_049() {
		driver.findElement(By.id("back-to-products")).click();
		driver.getCurrentUrl();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
	}
}
