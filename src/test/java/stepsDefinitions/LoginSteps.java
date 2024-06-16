package stepsDefinitions;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import pageObjects.ProductPage;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;
    ProductPage productPage;


    @Given("the user is on SauceDemo login page")
    public void navigateToLoginPage (){

        loginPage = new LoginPage(BaseClass.getDriver());

        String loginTitle = BaseClass.getDriver().getTitle();
        Assert.assertEquals(loginTitle, "Swag Labs");
    }

    @When("the user enters valid username: {string} and password: {string}")
    public void inputValidCredentials(String username, String password) {

        loginPage.setTxt_username(username);
        loginPage.setTxt_password(password);

    }

    @When("the user enters valid username: {string}>  and password: {string}>")
    public void the_user_enters_valid_username_and_password(String username, String password) {

        loginPage.setTxt_username(username);
        loginPage.setTxt_password(password);
    }

    @When("User clicks login button")
    public void clickLogin() {

        loginPage.clickLoginButton();
    }

    @Then("the user should see the product page")
    public void isProductPageDisplayed() {

        productPage = new ProductPage(BaseClass.getDriver());
        Assert.assertTrue(productPage.isProductLogoDisplayed());

    }


}
