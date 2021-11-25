package pages;

import model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import uk.co.automation.setup.BrowserFacade;

import java.util.List;

public class SelectionPage {

    public void addProductsToWishList(List<Product> products) {
        products.forEach( product -> {
            BrowserFacade.waitForElementToClickable(By.cssSelector("[data-original-product-id='" + product.getProductID() + "']"));

            WebElement Element = BrowserFacade.getDriver().findElement(By.cssSelector("[data-original-product-id='" + product.getProductID() + "']"));
            ((JavascriptExecutor) BrowserFacade.getDriver()).executeScript("arguments[0].scrollIntoView();", Element);
            BrowserFacade.waitForElementToAppear(By.cssSelector("[data-original-product-id='" + product.getProductID() + "']"));
            BrowserFacade.waitForElementToClickable(By.cssSelector("[data-original-product-id='" + product.getProductID() + "']")).click();
        });
    }

    public void goToWishList(){
        BrowserFacade.waitForElementToClickable(By.cssSelector("[title='Wishlist']")).click();
    }

}
