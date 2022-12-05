package saucelabsmain;

import java.util.List;
import Pageobjectmodels.Loginpagepo;
import Pageobjectmodels.Productdetailpagepo;
import Pageobjectmodels.Productspagepo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class filteroption {
	public WebDriver driver;
	public Loginpagepo login;
	public Productspagepo prod;
	public Productdetailpagepo pdetails;
	String productorderAZ[] = {"Sauce Labs Backpack",										//Product name on A-Z order
							   "Sauce Labs Bike Light",
							   "Sauce Labs Bolt T-Shirt",
							   "Sauce Labs Fleece Jacket",
							   "Sauce Labs Onesie",
							   "Test.allTheThings() T-Shirt (Red)"};
	int a=0;
	
	String productorderZA[] = {"Test.allTheThings() T-Shirt (Red)",							//Product name on Z-A order
							   "Sauce Labs Onesie",
							   "Sauce Labs Fleece Jacket",
							   "Sauce Labs Bolt T-Shirt",
							   "Sauce Labs Bike Light",
							   "Sauce Labs Backpack"};
	int b=0;
	
	String productorderLH[] = {"Sauce Labs Onesie",											//Product name on L-H order
							   "Sauce Labs Bike Light",
							   "Sauce Labs Bolt T-Shirt",
							   "Test.allTheThings() T-Shirt (Red)",
							   "Sauce Labs Backpack",
							   "Sauce Labs Fleece Jacket"};
	int c=0;
	
	String productorderHL[] = {"Sauce Labs Fleece Jacket",									//Product name on H-L order
							   "Sauce Labs Backpack",
							   "Sauce Labs Bolt T-Shirt",
							   "Test.allTheThings() T-Shirt (Red)",
							   "Sauce Labs Bike Light",
							   "Sauce Labs Onesie"};
	int d=0;

	@BeforeMethod
	public void open() throws InterruptedException {																		//Startup steps
		driver = new ChromeDriver();
		login = new Loginpagepo(driver);
		prod = new Productspagepo(driver);
		pdetails = new Productdetailpagepo(driver);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		login.setUsername("standard_user");
		login.setPassword("secret_sauce");
		login.setLoginbutton();
		prod.setSortoption();
		Thread.sleep(2000);
	}
	@AfterMethod																									    //Final Steps
	public void close() {
		driver.quit();
	}
	@Test 
	public void TC_019() throws InterruptedException{																	
		prod.setAzfilter();
		Thread.sleep(2000);
		List<WebElement> currentnameorder = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		for(WebElement order: currentnameorder) {
			order.getText();
			Assert.assertEquals(order.getText(),productorderAZ[a]);														//Comparing the order of the products
			a++;
		}		
	}
	@Test
	public void TC_020() throws InterruptedException{
		prod.setZafilter();													//Clicking the Z-A Filter option
		Thread.sleep(2000);
		List<WebElement> currentnameorder = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		for(WebElement order: currentnameorder) {
			order.getText();
			Assert.assertEquals(order.getText(),productorderZA[b]);														//Comparing the order of the products
			b++;
		}		
	}
	@Test
	public void TC_021() throws InterruptedException{
		prod.setLhfilter();
		Thread.sleep(2000);
		List<WebElement> currentnameorder = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		for(WebElement order: currentnameorder) {
			order.getText();
			Assert.assertEquals(order.getText(),productorderLH[c]);														//Comparing the order of the products
			c++;
		}		
	}
	@Test
	public void TC_022() throws InterruptedException{
		prod.setHlfilter();										//Clicking the H-L Filter option
		Thread.sleep(2000);
		List<WebElement> currentnameorder = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		for(WebElement order: currentnameorder) {
			order.getText();
			Assert.assertEquals(order.getText(),productorderHL[d]);														//Comparing the order of the products
			d++;
		}		
	}
	@Test
	public void TC_023() throws InterruptedException{
		prod.setZafilter();													//Clicking the Z-A Filter option
		Thread.sleep(2000);
		pdetails.setProductname();
		pdetails.setBacktoprod();
		List<WebElement> currentnameorder = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		for(WebElement order: currentnameorder) {
			order.getText();
			Assert.assertEquals(order.getText(),productorderZA[b]);														//Comparing the order of the products
			b++;
		}
	}
}
