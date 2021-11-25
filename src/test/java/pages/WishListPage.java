package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import uk.co.automation.setup.BrowserFacade;

import java.util.*;

public class WishListPage {
    public int countNumberOfProductsInWishList() {
        List<WebElement> rows = BrowserFacade.getDriver().findElements(By.cssSelector("[class='shop_table cart wishlist_table wishlist_view traditional responsive   '] tr"));
        return rows.size() - 1;
    }

    public Map.Entry<String, Double> findTheLowestPricedProduct() {
        List<WebElement> rows = BrowserFacade.getDriver().findElements(By.cssSelector("[class='shop_table cart wishlist_table wishlist_view traditional responsive   '] tr"));
        Map<String, Double> map = new HashMap();

        for(int i = 1; i < rows.size(); i++){
            WebElement currentRow = rows.get(i);
            WebElement insElement;
            String productId = currentRow.getAttribute("data-row-id");
            try {
                insElement = currentRow.findElement(By.tagName("ins"));
                //TODO:: use String.format instead of hardcoding
                map.put(productId, Double.parseDouble(insElement.findElement(By.tagName("bdi")).getText().split("£")[1]));
            } catch (Exception e) {
                map.put(productId, Double.parseDouble(currentRow.findElement(By.tagName("bdi")).getText().split("£")[1]));
            }
        }
        Optional<Map.Entry<String, Double>> lowestProductEntry = map.entrySet().stream().min(Comparator.comparing(Map.Entry::getValue));
        return lowestProductEntry.get();
    }

    public void addLowestPricedProductToCart(Map.Entry<String, Double> theLowestPricedProduct) {
        BrowserFacade.waitForElementToClickable(By.xpath("//*[@id=\"yith-wcwl-row-" + theLowestPricedProduct.getKey() + "\"]/td[6]/a")).click();
    }

    public boolean verifyProductAddedToCart() {
        return BrowserFacade.waitForElementToClickable(By.cssSelector("[class='woocommerce-message']")).isDisplayed();
    }

    public void gotoCart() {
        BrowserFacade.waitForElementToClickable(By.cssSelector("[title='Cart']")).click();
    }
}
