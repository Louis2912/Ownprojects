package Pageobjectmodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Productspagepo {

    public WebDriver driver;
    public Productspagepo(WebDriver newdriver){
        driver = newdriver;
        PageFactory.initElements(newdriver,this);
    }

    @FindBy(how = How.ID,using = "shopping_cart_container")
    WebElement yourscartbutton;
    @FindBy(how = How.XPATH, using = "//select[@class='product_sort_container']")
    WebElement sortoption;
    @FindBy(how = How.ID, using = "react-burger-menu-btn")
    WebElement menubutton;
    @FindBy(how = How.XPATH, using = "//div[@class='inventory_item_label']/a/div")
    WebElement producttext;
    @FindBy(how = How.XPATH, using = "//option[@value='az']")
    WebElement azfilter;
    @FindBy(how = How.XPATH, using = "//option[@value='za']")
    WebElement zafilter;
    @FindBy(how = How.XPATH, using = "//option[@value='lohi']")
    WebElement lhfilter;
    @FindBy(how = How.XPATH, using = "//option[@value='hilo']")
    WebElement hlfilter;
    @FindBy(how = How.ID, using = "inventory_sidebar_link")
    WebElement allitems;
    @FindBy(how = How.ID, using = "about_sidebar_link")
    WebElement about;
    @FindBy(how = How.ID, using = "logout_sidebar_link")
    WebElement logout;
    @FindBy(how = How.ID, using = "reset_sidebar_link")
    WebElement reset;
    @FindBy(how = How.XPATH, using = "//a[text()='Twitter']")
    WebElement twitter;
    @FindBy(how = How.XPATH, using = "//a[text()='Facebook']")
    WebElement facebook;
    @FindBy(how = How.XPATH, using = "//a[text()='LinkedIn']")
    WebElement linkdin;
    @FindBy(how = How.XPATH,using = "//div[text()='Sauce Labs Backpack']")
    WebElement productname;
    @FindBy(how = How.XPATH, using = "//button[@class='btn btn_primary btn_small btn_inventory']")
    WebElement addtocart;

    public void setYourscartbutton(){
        yourscartbutton.click();
    }
    public void setSortoption(){
        sortoption.click();
    }
    public void setMenubutton(){
        menubutton.click();
    }
    public void setAzfilter(){
        azfilter.click();
    }
    public void setZafilter(){
        zafilter.click();
    }
    public void setLhfilter(){
        lhfilter.click();
    }
    public void setHlfilter(){
        hlfilter.click();
    }
    public void setAllitems(){
        allitems.click();
    }
    public void setAbout(){
        about.click();
    }
    public void setLogout(){
        logout.click();
    }
    public void setReset(){
        reset.click();
    }
    public void setTwitter(){
        twitter.click();
    }
    public void setFacebook(){facebook.click();}
    public void setLinkdin(){
        linkdin.click();
    }
    public void setProductname(){
        productname.click();
    }
    public void setAddtocart (){
        addtocart.click();
    }


}
