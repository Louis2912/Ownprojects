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

public class Autologoutfunction {
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
		prod.setProductname();
	}
	@AfterMethod																									//Final Steps
	public void close() {
		driver.quit();
	}
	
	@Test
	public void TC_050() throws InterruptedException {
		Thread.sleep(600000);
		pdeatil.setBacktoprod();
		driver.getCurrentUrl();
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/");
	}
}
