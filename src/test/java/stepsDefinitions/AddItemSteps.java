package stepsDefinitions;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import pageObjects.YourCartPage;

public class AddItemSteps {

    LoginPage loginPage;
    ProductPage productPage;
    YourCartPage yourCartPage;


//    @Given("the user is on the Product page")
//    public void the_user_is_on_the_product_page() {
//
//        productPage = new ProductPage(BaseClass.getDriver());
//        Assert.assertTrue(productPage.isProductLogoDisplayed());
//
//    }

    @Given("the user is on the Product page")
    public void the_user_is_on_the_product_page() {

        loginPage = new LoginPage(BaseClass.getDriver());
        String loginTitle = BaseClass.getDriver().getTitle();
        Assert.assertEquals(loginTitle, "Swag Labs");
        loginPage.setTxt_username("standard_user");
        loginPage.setTxt_password("secret_sauce");
        loginPage.clickLoginButton();

        productPage = new ProductPage(BaseClass.getDriver());
        Assert.assertTrue(productPage.isProductLogoDisplayed());
    }

    @When("the user sorts the products")
    public void the_user_sorts_the_products() {

        productPage.sortProductsItems();
    }

    @When("User clicks add to cart button")
    public void user_clicks_add_to_cart_button() {

        productPage.addSixItems();
    }

    @Then("the six products should be added to cart waiting checkout")
    public void the_six_products_should_be_added_to_cart_waiting_checkout() {

        Assert.assertTrue(productPage.checkSixItemsAddedToCart());
    }
}
