package stepsDefinitions;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.*;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class CheckoutSteps {

    WebDriver driver;

    LoginPage loginPage;
    ProductPage productPage;
    YourCartPage yourCartPage;
    CheckOutInfoPage checkOutInfoPage;
    CheckOverviewPage checkOverviewPage;
    CheckOutCompletePage checkOutCompletePage;
    Properties p;


    @Given("the products are added to cart")
    public void the_products_are_added_to_cart() {

        loginPage = new LoginPage(BaseClass.getDriver());
        String loginTitle = BaseClass.getDriver().getTitle();
        Assert.assertEquals(loginTitle, "Swag Labs");
        loginPage.setTxt_username("standard_user");
        loginPage.setTxt_password("secret_sauce");
        loginPage.clickLoginButton();

        productPage = new ProductPage(BaseClass.getDriver());
        Assert.assertTrue(productPage.isProductLogoDisplayed());
        productPage.addSixItems();
        Assert.assertTrue(productPage.checkSixItemsAddedToCart());

//        productPage = new ProductPage(BaseClass.getDriver());
//        Assert.assertTrue(productPage.checkSixItemsAddedToCart());
    }

    @Given("user is on Your cart page")
    public void user_is_on_your_cart_page() {

        productPage.clickFilterButton();

        yourCartPage = new YourCartPage(BaseClass.getDriver());
        Assert.assertTrue(yourCartPage.isYourCartPageDisplayed());
    }

    @When("the user clicks checkout")
    public void the_user_clicks_checkout() {

        yourCartPage.clickCheckOutButton();
    }

    @When("User input checkout details below")
    public void user_input_checkout_details_below(DataTable dataTable) throws IOException {

//        p = BaseClass.getProperties();
//        checkOutInfoPage = new CheckOutInfoPage(BaseClass.getDriver());
//        checkOutInfoPage.setFirstName(p.getProperty("customerFirstName"));
//        checkOutInfoPage.setLastName(p.getProperty("customerLastName"));
//        checkOutInfoPage.setPostcode(p.getProperty("postcode"));
//        checkOutInfoPage.clickContinueButton();

        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

        checkOutInfoPage = new CheckOutInfoPage(BaseClass.getDriver());
        checkOutInfoPage.setFirstName(dataMap.get("firstname"));
        checkOutInfoPage.setLastName(dataMap.get("lastname"));
        checkOutInfoPage.setPostcode(dataMap.get("postcode"));
        checkOutInfoPage.clickContinueButton();
    }

    @Then("user clicks finish button and user is checkout is complete")
    public void user_clicks_finish_button_and_user_is_checkout_is_complete() {

        checkOverviewPage= new CheckOverviewPage(BaseClass.getDriver());
        checkOverviewPage.clickFinishButton();

        checkOutCompletePage= new CheckOutCompletePage(BaseClass.getDriver());
        Assert.assertTrue(checkOutCompletePage.isThankYouIconDisplayed());

    }
}
