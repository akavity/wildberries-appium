package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.CartPage;
import org.akavity.utils.Utils;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.exist;

@Log4j2
public class CartSteps {
    CartPage cartPage = new CartPage();
    Utils utils = new Utils();

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

    @Step
    public void decreaseProductQuantity() {
        log.info("Click decrease quantity button");
        cartPage.getDecreaseQuantityButton().click();
    }

    @Step
    public void decreaseProductQuantity(int click) {
        log.info("Click decrease quantity button " + click + " times");
        for (int i = 0; i < click; i++) {
            cartPage.getDecreaseQuantityButton().click();
            utils.sleep();
        }
    }

    @Step
    public void increaseProductQuantity() {
        log.info("Click increase product quantity");
        cartPage.getIncreaseQuantityButton().click();
    }

    @Step
    public void increaseProductQuantity(int click) {
        utils.sleep();
        log.info("Click increase quantity button " + click + " times");
        for (int i = 0; i < click; i++) {
            cartPage.getIncreaseQuantityButton().shouldBe(clickable).click();
        }
        utils.sleep();
    }

    @Step
    public int getProductQuantity() {
        utils.sleep(1300);
        int qty = Integer.parseInt(cartPage.getProductQuantityField().getText());
        log.info("Product quantity: {}", qty);
        return qty;
    }

    @Step
    public double getProductPrice() {
        utils.sleep(1300);
        String text = cartPage.getProductPriceField().shouldBe(exist).getText();
        log.info("Product price Text: {}", text);
        double price = utils.extractPriceFromText(text).doubleValue();
        log.info("The product price in the cart: {}", price);
        return price;
    }
}
