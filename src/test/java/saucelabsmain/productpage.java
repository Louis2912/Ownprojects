package saucelabsmain;

import java.util.List;

import Pageobjectmodels.Loginpagepo;
import Pageobjectmodels.Productspagepo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class productpage {
	
	public WebDriver driver;																						//Startup steps
	public Productspagepo prod;
	public Loginpagepo login;
	@BeforeMethod
	public void open() throws InterruptedException {
		driver = new ChromeDriver();
		prod = new Productspagepo(driver);
		login = new Loginpagepo(driver);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		login.setUsername("standard_user");
		login.setPassword("secret_sauce");
		login.setLoginbutton();
	}
	@AfterMethod																									//Final Steps
	public void close() {
		driver.quit();
	}
	
	@Test
	public void TC_010() {
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='app_logo']")).getCssValue("text-align"), "center"); //check the logo present in centre or not
	}
	@Test
	public void TC_011() {
		prod.setYourscartbutton();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");         //checking the yours cart page opened or not
	}
	@Test
	public void TC_012() {
		prod.setSortoption();
		Assert.assertEquals(driver.findElement(By.xpath("//select[@class='product_sort_container']")).isDisplayed(), true);  //check the drop down selected or not
	}
	@Test
	public void TC_013() throws InterruptedException {
		int a=0;															
		String listarrey[] = {"ALL ITEMS","ABOUT","LOGOUT","RESET APP STATE"};								//Default values(Expected)			
		prod.setMenubutton();
		Thread.sleep(5000);
		List<WebElement> optionlist = driver.findElements(By.xpath("//nav/a"));								//Fetching the Menu options
		for(WebElement list: optionlist) {
			Assert.assertEquals(list.getText(),listarrey[a]);												//comparing the actual values with expected
			a++;
		}
	}
	@Test
	public void TC_014() {
		int a=0;	
		String productarrey[] = {"Sauce Labs Backpack","Sauce Labs Bike Light","Sauce Labs Bolt T-Shirt",					//Default product names
								 "Sauce Labs Fleece Jacket","Sauce Labs Onesie","Test.allTheThings() T-Shirt (Red)"};
		List<WebElement> productlist = driver.findElements(By.xpath("//div[@class='inventory_item_label']/a/div"));
		for(WebElement name: productlist) {
			Assert.assertEquals(name.getText(),productarrey[a]);															//comparing the actual values with expected
			a++;
		}
	}
	@Test
	public void TC_015() throws InterruptedException {
		Object productname[] = new Object [6];
		int a=0;
		int b=0;
		List<WebElement> addtocart = driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));		//clicking the Every product add to cart button
		for(WebElement cart : addtocart) {
			cart.click();
		}
		Thread.sleep(3000);
		List<WebElement> productnamelist = driver.findElements(By.xpath("//div[@class='inventory_item_label']/a/div"));		//Fetching the Every product name on product page			
		for(WebElement name: productnamelist) {
			productname [a]=name.getText();																					//storing the Fetched names
			a++;
		}
		driver.findElement(By.id("shopping_cart_container")).click();													    //clicking the yours cart button
		List<WebElement> addedproductnamelist = driver.findElements(By.xpath("//div[@class='cart_item_label']/a/div"));     // Fetching the Every product name on yours cart page
		for(WebElement addedname:addedproductnamelist) {
			addedname.getText();																				
			Assert.assertEquals(addedname.getText(), productname[b]);													    //comparing the cart page names with product page names
			b++; 
		}

		
	}
	
}
