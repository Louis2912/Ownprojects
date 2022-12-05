package saucelabsmain;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Loginpage {
	public WebDriver driver;
	
	@BeforeMethod
	public void open() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void close() {
		driver.quit();
	}
	
	@Test
	public void TC_001() throws InterruptedException {
		driver.get("https://www.saucedemo.com/");
	}
	
	@Test
	public void TC_002() throws InterruptedException {
		driver.get("https://www.saucedemo.com/");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login_logo']")).getCssValue("text-align"),"center");
	}
}
