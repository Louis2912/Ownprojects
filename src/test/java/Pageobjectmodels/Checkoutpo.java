package Pageobjectmodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Checkoutpo {
    public WebDriver driver;
    public Checkoutpo(WebDriver newdriver){
        driver = newdriver;
        PageFactory.initElements(newdriver,this);
    }
    @FindBy(how = How.ID, using = "first-name")
    WebElement fname;
    @FindBy(how = How.ID, using = "last-name")
    WebElement lname;
    @FindBy(how = How.ID, using = "postal-code")
    WebElement pincode;
    @FindBy(how = How.ID, using = "continue")
    WebElement continuebutton;
    @FindBy(how = How.ID, using = "cancel")
    WebElement cancel;
    @FindBy(how = How.XPATH, using = "//h3")
    WebElement errortext;

    public void setFname(String firstname){
        fname.sendKeys(firstname);
    }
    public void setLname(String lastname){
        lname.sendKeys(lastname);
    }
    public void setPincode(String zipcode){
        pincode.sendKeys(zipcode);
    }
    public void setContinuebutton(){
        continuebutton.click();
    }
    public void setCancel(){
        cancel.click();
    }
    public String setErrortext(){
        String error = errortext.getText();
        return error;
    }
    public void setErrortext(WebElement errortext){
        this.errortext = errortext;
    }
}
