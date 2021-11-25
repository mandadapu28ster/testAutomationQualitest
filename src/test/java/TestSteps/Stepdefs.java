package TestSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.Product;
import org.junit.Assert;
import pages.CartPage;
import pages.SelectionPage;
import pages.WishListPage;
import uk.co.automation.setup.Context;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Stepdefs {
    private List<Product> products = Arrays.asList(
                new Product("20"),
            new Product("14"),
            new Product("18"),
            new Product("22"));
    private SelectionPage selectionPage = new SelectionPage();
    private WishListPage wishListPage = new WishListPage();
    private CartPage cartPage = new CartPage();
    Map.Entry<String, Double> theLowestPricedProduct;

    @Given("^i am on product selection page$")
    public void iAmOnProductSelectionPage() throws Exception {
        Context.getInstance().clearCookies();
        Context.getInstance().goTo("https://testscriptdemo.com/");
    }


    @Given("^i add four different products to my wish list$")
    public void iAddFourDifferentProductsToMyWishList() {
        selectionPage.addProductsToWishList(products);
    }

    @When("^i view my wishlist table$")
    public void iViewMyWishlistTable() {
        selectionPage.goToWishList();
    }

    @Then("^i find total four selected items in my Wishlist$")
    public void iFindTotalFourSelectedItemsInMyWishlist() {
        Assert.assertTrue(4 == wishListPage.countNumberOfProductsInWishList());
    }

    @When("^i search for lowest price product$")
    public void iSearchForLowestPriceProduct() {
        theLowestPricedProduct = wishListPage.findTheLowestPricedProduct();
    }

    @And("^i am able to add the lowest price item to my cart$")
    public void iAmAbleToAddTheLowestPriceItemToMyCart() {
        wishListPage.addLowestPricedProductToCart(theLowestPricedProduct);
        Assert.assertTrue(wishListPage.verifyProductAddedToCart());
    }

    @Then("^i am able to verify the item in my cart$")
    public void iAmAbleToVerifyTheItemInMyCart() {
        wishListPage.gotoCart();
        Assert.assertTrue(theLowestPricedProduct.getKey().equals(cartPage.getItemFromCart()));
    }

}
