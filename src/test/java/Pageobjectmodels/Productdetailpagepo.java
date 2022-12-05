package Pageobjectmodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Productdetailpagepo {
    public WebDriver driver;

    public Productdetailpagepo(WebDriver newdriver){
        driver = newdriver;
        PageFactory.initElements(newdriver,this);
    }

    @FindBy(how = How.XPATH,using = "//div[text()='Sauce Labs Backpack']")
    WebElement productname;
    @FindBy(how = How.ID, using = "back-to-products")
    WebElement backtoprod;
    @FindBy(how = How.ID, using = "add-to-cart-sauce-labs-backpack")
    WebElement addtocart;

    public void setProductname(){
        productname.click();
    }
    public void setBacktoprod(){
        backtoprod.click();
    }
    public void setAddtocart(){
        addtocart.click();
    }

}
