package org.akavity.pages;

import com.codeborne.selenide.appium.SelenideAppiumCollection;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.appium.SelenideAppium.$$;

public class ProductListPage {
    private final SelenideAppiumCollection productContainer = $$(AppiumBy.xpath("(//android.view.ViewGroup[contains(@resource-id,'itemLayout')])"));
    private final SelenideAppiumCollection addToCartButtons = $$(AppiumBy.id("com.wildberries.ru:id/buttonToCartWithDelivery"));
    private final SelenideAppiumCollection priceFields = $$(AppiumBy.id("com.wildberries.ru:id/textCurrentPrice"));
    private final SelenideAppiumCollection brandFields = $$(AppiumBy.id("com.wildberries.ru:id/textProductBrand"));
    private final SelenideAppiumCollection favoriteButtons = $$(AppiumBy.id("com.wildberries.ru:id/buttonToFavorite"));

    public SelenideAppiumCollection getFigures(String figure) {
        return $$(AppiumBy.xpath("//android.widget.TextView[contains(@content-desc,'" + figure + "')]"));
    }

    public SelenideAppiumCollection getProductContainer() {
        return productContainer;
    }

    public SelenideAppiumCollection getAddToCartButtons() {
        return addToCartButtons;
    }

    public SelenideAppiumCollection getPriceFields() {
        return priceFields;
    }

    public SelenideAppiumCollection getBrandFields() {
        return brandFields;
    }

    public SelenideAppiumCollection getFavoriteButtons() {
        return favoriteButtons;
    }
}
