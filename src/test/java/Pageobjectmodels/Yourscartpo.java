package Pageobjectmodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Yourscartpo {
    public WebDriver driver;
    public Yourscartpo(WebDriver newdriver){
        driver = newdriver;
        PageFactory.initElements(newdriver,this);
    }
    @FindBy(how = How.XPATH, using = "//div[@class='cart_quantity']")
    WebElement quantity;
    @FindBy(how = How.ID, using = "continue-shopping")
    WebElement continueshopping;
    @FindBy(how = How.ID, using = "remove-sauce-labs-backpack")
    WebElement removeprod;
    @FindBy(how = How.XPATH, using = "//div[@class='inventory_item_name']")
    WebElement prodnameoncart;
    @FindBy(how = How.ID, using = "checkout")
    WebElement checkoutbutton;

    public boolean setQuantity(){
       boolean qty = quantity.isDisplayed();
       return qty;
    }
    public void setQuantity(boolean quantity){
        boolean qty = quantity;
    }
    public void setContinueshopping(){
        continueshopping.click();
    }
    public void setRemoveprod(){
        removeprod.click();
    }
    public void setProdnameoncart(){
        prodnameoncart.getText();
    }
    public void setCheckoutbutton(){
        checkoutbutton.click();
    }
}
