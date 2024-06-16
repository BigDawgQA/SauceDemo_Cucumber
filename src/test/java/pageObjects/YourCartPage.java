package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourCartPage extends BasePage{

    public YourCartPage(WebDriver driver){

        super(driver);

    }


    @FindBy(xpath="//div/span[text()='Your Cart']") WebElement your_Cart_Img;
    @FindBy(xpath="//button[@id='continue-shopping']") WebElement continueShoppingButton;
    @FindBy(xpath="//button[@id='checkout']") WebElement checkoutButton;



    public boolean isYourCartPageDisplayed(){

        return (your_Cart_Img.isDisplayed());
    }
    public void clickCheckOutButton(){
        checkoutButton.click();

    }

}
