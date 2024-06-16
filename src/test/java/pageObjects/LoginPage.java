package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//input[@id='user-name']")
    WebElement txt_username;
    @FindBy(xpath="//input[@id='password']") WebElement txt_password;
    @FindBy(xpath="//input[@id='login-button']") WebElement loginButton;



    public void title(){

    }
    public void setTxt_username(String username){
        txt_username.sendKeys(username);
    }

    public void setTxt_password(String password){
        txt_password.sendKeys(password);
    }
    public void clickLoginButton(){
        loginButton.click();
    }






}
