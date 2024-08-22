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
    public boolean isTheProductDisplayed(String text) {
        String product = cartPage.getProductNameField().getText();
        boolean result = product.toLowerCase().contains(text.toLowerCase());
        log.info("Is the product {} displayed: {} - '{}'", text, result, product);
        return result;
    }
}
