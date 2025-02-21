package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.CartPage;

@Log4j2
public class CartSteps {
    CartPage cartPage = new CartPage();

    @Step
    public boolean isTheCartEmpty() {
        boolean result = cartPage.getEmptyCartField().isDisplayed();
        log.info("Is the cart empty: {}", result);
        return result;
    }

    @Step
    public boolean checkProductName(String[] partsOfName) {
        boolean result = true;
        String product = cartPage.getProductNameFields().get(0).getText().toLowerCase();
        for (String part : partsOfName) {
            if (!product.contains(part.toLowerCase())) {
                log.info("Product '{}' does NOT contain '{}'", product, part);
                result = false;
            } else {
                log.info("Product '{}' contains '{}'", product, part);
            }
        }
        return result;
    }

    @Step
    public void removeProduct() {
        log.info("Remove a product from the cart");
        cartPage.getProductMenuButton().click();
        cartPage.getRemoveProductButton().click();
    }
}
