package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import uk.co.automation.setup.BrowserFacade;

import java.util.List;

public class CartPage {
    public String getItemFromCart() {
        List<WebElement> rows = BrowserFacade.getDriver().findElements(By.cssSelector("[class='shop_table shop_table_responsive cart woocommerce-cart-form__contents'] tr"));
        WebElement firstRow = rows.get(1);
        return firstRow.findElement(By.cssSelector("[class='remove']")).getAttribute("data-product_id");
    }
}
