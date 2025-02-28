package org.akavity.pages;

import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.codeborne.selenide.appium.SelenideAppium.$$;

public class CartPage {
    private final SelenideAppiumElement emptyCartField = $(AppiumBy.xpath("//android.widget.TextView[contains(@text,'корзине пусто')]"));
    private final SelenideAppiumCollection productNameFields = $$(AppiumBy.xpath("//android.widget.TextView[@resource-id='productName']"));
    private final SelenideAppiumElement productMenuButton = $(AppiumBy.xpath("//android.view.View[@resource-id='productMenu']"));
    private final SelenideAppiumElement removeProductButton = $(AppiumBy.xpath("//android.widget.TextView[@text='Удалить']"));
    private final SelenideAppiumElement decreaseQuantityButton = $(AppiumBy.xpath("//android.view.View[@resource-id='productQuantityDecrement']"));
    private final SelenideAppiumElement increaseQuantityButton = $(AppiumBy.xpath("//android.view.View[@resource-id='productQuantityIncrement']"));
    private final SelenideAppiumElement productQuantityField = $(AppiumBy.xpath("//android.widget.TextView[@resource-id='productQuantity']"));
    private final SelenideAppiumElement productPriceField = $(AppiumBy.xpath("//android.widget.TextView[@resource-id='productPrice']"));

    public SelenideAppiumElement getEmptyCartField() {
        return emptyCartField;
    }

    public SelenideAppiumCollection getProductNameFields() {
        return productNameFields;
    }

    public SelenideAppiumElement getProductMenuButton() {
        return productMenuButton;
    }

    public SelenideAppiumElement getRemoveProductButton() {
        return removeProductButton;
    }

    public SelenideAppiumElement getDecreaseQuantityButton() {
        return decreaseQuantityButton;
    }

    public SelenideAppiumElement getIncreaseQuantityButton() {
        return increaseQuantityButton;
    }

    public SelenideAppiumElement getProductQuantityField() {
        return productQuantityField;
    }

    public SelenideAppiumElement getProductPriceField() {
        return productPriceField;
    }
}
