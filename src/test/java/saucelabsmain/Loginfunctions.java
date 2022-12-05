package saucelabsmain;

import Pageobjectmodels.Loginpagepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Loginfunctions {
	public WebDriver driver;
	public Loginpagepo login;

	@BeforeMethod
	public void open() throws InterruptedException {
		driver = new ChromeDriver();
		login = new Loginpagepo(driver);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}
	@AfterMethod
	public void close() {
		driver.quit();
	}
	
	@Test
	public void TC_003() {
		login.setUsername("standard_user200");
		login.setPassword("secret_sauce123");
		login.setLoginbutton();
		Assert.assertEquals(login.setErrortext(), "Epic sadface: Username and password do not match any user in this service");
	}
	@Test
	public void TC_004() {
		login.setUsername("standard_user200");
		login.setPassword("secret_sauce");
		login.setLoginbutton();
		Assert.assertEquals(login.setErrortext(), "Epic sadface: Username and password do not match any user in this service");
	}
	@Test
	public void TC_005() {
		login.setUsername("standard_user");
		login.setPassword("secret_sauce123");
		login.setLoginbutton();
		Assert.assertEquals(login.setErrortext(), "Epic sadface: Username and password do not match any user in this service");
	}
		
	@Test
	public void TC_006() {
		login.setUsername("standard_user");
		login.setPassword("");
		login.setLoginbutton();
		Assert.assertEquals(login.setErrortext(), "Epic sadface: Password is required");
		
	}
	@Test
	public void TC_007() {
		login.setUsername("");
		login.setPassword("secret_sauce123");
		login.setLoginbutton();
		Assert.assertEquals(login.setErrortext(), "Epic sadface: Username is required");
		
	}
	@Test
	public void TC_008() {
		login.setUsername("");
		login.setPassword("");
		login.setLoginbutton();
		Assert.assertEquals(login.setErrortext(), "Epic sadface: Username is required");
		
	}
	@Test
	public void TC_009() {
		login.setUsername("standard_user");
		login.setPassword("secret_sauce");
		login.setLoginbutton();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
	}
}
		
	
		
		

	
