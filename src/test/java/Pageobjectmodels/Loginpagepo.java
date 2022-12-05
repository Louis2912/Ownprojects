package Pageobjectmodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Loginpagepo {

   public WebDriver driver;

    public Loginpagepo(WebDriver newdriver){
       driver = newdriver;
       PageFactory.initElements(newdriver, this);
   }


    @FindBy(how = How.ID, using = "user-name")
        WebElement username;
    @FindBy(how = How.ID,using = "password")
        WebElement password;
    @FindBy(how = How.ID,using = "login-button")
        WebElement loginbutton;
    @FindBy(how = How.XPATH,using = "//h3")
        WebElement errortext;

    public void setUsername(String usname){
        username.sendKeys(usname);
    }
    public void setPassword(String pwd){
        password.sendKeys(pwd);
    }
    public void setLoginbutton(){
        loginbutton.click();
    }
    public String setErrortext(){
      String error = errortext.getText();
      return error;
    }
    public void setErrortext(WebElement errortext) {
        this.errortext = errortext;
    }

}
