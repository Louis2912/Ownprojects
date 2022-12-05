package saucelabsmain;

import java.util.Set;

import Pageobjectmodels.Loginpagepo;
import Pageobjectmodels.Productspagepo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Socialmedia {
		public WebDriver driver;																					//Startup steps
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
			Thread.sleep(2000);
		}
		@AfterMethod																								//Final Steps
		public void close() {
			driver.quit();
		}
		
		@Test
		public void TC_029() throws InterruptedException {															//Twitter
			String homehandle =driver.getWindowHandle();
			prod.setTwitter();
			Thread.sleep(3000);
			Set<String> handles= driver.getWindowHandles();
			for (String handle: handles) {
				if(!handle.equalsIgnoreCase(homehandle)) {
					driver.switchTo().window(handle);
					driver.getCurrentUrl();
					Assert.assertEquals(driver.getCurrentUrl(),"https://twitter.com/saucelabs");					//checking page opened or not
				}
			}
		}
		@Test
		public void TC_030() throws InterruptedException {															//Facebook
			String homehandle =driver.getWindowHandle();
			prod.setFacebook();
			Thread.sleep(3000);
			Set<String> handles= driver.getWindowHandles();
			for (String handle: handles) {
				if(!handle.equalsIgnoreCase(homehandle)) {
					driver.switchTo().window(handle);
					driver.getCurrentUrl();
					Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/saucelabs");				//checking page opened or not
				}
			}
		}
		@Test
		public void TC_031() throws InterruptedException {															//LinkdIn
			String homehandle =driver.getWindowHandle();
			prod.setLinkdin();
			Thread.sleep(3000);
			Set<String> handles= driver.getWindowHandles();
			for (String handle: handles) {
				if(!handle.equalsIgnoreCase(homehandle)) {
					driver.switchTo().window(handle);
					Assert.assertEquals(driver.getTitle(),"Sign In | LinkedIn");									//checking page opened or not
				}
			}
		}
}
