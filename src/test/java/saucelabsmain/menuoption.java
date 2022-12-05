package saucelabsmain;

import Pageobjectmodels.Loginpagepo;
import Pageobjectmodels.Productspagepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class menuoption {
	public WebDriver driver;																							//Startup steps
	public Loginpagepo login;
	public Productspagepo prod;
	@BeforeMethod
	public void open() throws InterruptedException {
		driver = new ChromeDriver();
		login = new Loginpagepo(driver);
		prod = new Productspagepo(driver);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		login.setUsername("standard_user");
		login.setPassword("secret_sauce");
		login.setLoginbutton();
		prod.setMenubutton();
		Thread.sleep(2000);
	}
	@AfterMethod																									  //Final Steps
	public void close() {
		driver.quit();
	}
	@Test
	public void TC_024() {
		prod.setAllitems();												  //All items menu
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");					  //Checking redirected or not
	}
	@Test
	public void TC_025() {																	
		prod.setAbout();													  //About menu
		Assert.assertEquals(driver.getCurrentUrl(), "https://saucelabs.com/");										  //Checking redirected or not
	}
	@Test
	public void TC_026() {
		prod.setLogout();												  //Logout menu
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");									  //Checking redirected or not
	}
	@Test
	public void TC_027() {
		prod.setReset();												  //Reset menu
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");					  //Checking redirected or not
	} 
	@Test
	public void TC_028() throws InterruptedException {																 
		prod.setLogout();													 //logout Function
		driver.navigate().back();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");									  //Checking redirected or not
		Assert.assertEquals(login.setErrortext(), "Epic sadface: You can only access '/inventory.html' when you are logged in."); //Checking the Error shown or not
	}

}
