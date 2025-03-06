package org.akavity.steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.ProductListPage;
import org.akavity.utils.Utils;

@Log4j2
public class ProductListSteps {
    ProductListPage productListPage = new ProductListPage();
    Utils utils = new Utils();

    @Step
    public boolean isProductDisplayed(String name) {
        SelenideElement el = productListPage.getProductNameFields().first();
        boolean result = el.getText().toLowerCase().contains(name.toLowerCase());
        log.info("Is product {} displayed: {} - '{}'", name, result, el.getText());
        return result;
    }

    @Step
    public void clickFirstProduct() {
        log.info("Click on the first product");
        productListPage.getProductContainer().first().click();
    }

    @Step
    public void clickFirstButtonAddToCart() {
        log.info("Click on the first 'Add to cart' button");
        productListPage.getAddToCartButtons()
                .first()
                .scrollTo()
                .click();
    }

    @Step
    public double getPriceFirstProduct() {
        double result = utils.extractPriceFromText(productListPage.getPriceFields().first().getText()).doubleValue();
        log.info("Price first product: {}", result);
        return result;
    }

    @Step
    public String getProductBrand() {
        String result = productListPage.getBrandFields().first().getText();
        log.info("Brand name first product: {}", result);
        return result;
    }

    @Step
    public void addProductToFavorite() {
        log.info("The first product has been added to Favorite");
        productListPage.getFavoriteButtons()
                .first()
                .click();
    }
}
