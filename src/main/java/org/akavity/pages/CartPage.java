package org.akavity.pages;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.appium.SelenideAppium.$;

public class CartPage {
    private final SelenideAppiumElement emptyCartField = $(AppiumBy.xpath("//android.widget.TextView[contains(@text,'корзине пусто')]"));
    private final SelenideAppiumElement productNameField = $(AppiumBy.xpath("//android.widget.TextView[@resource-id='productName']"));
    private final SelenideAppiumElement productMenuButton = $(AppiumBy.xpath("//android.view.View[@resource-id='productMenu']"));
    private final SelenideAppiumElement removeProductButton = $(AppiumBy.xpath("//android.widget.TextView[@text='Удалить']"));

    public SelenideAppiumElement getEmptyCartField() {
        return emptyCartField;
    }

    public SelenideAppiumElement getProductNameField() {
        return productNameField;
    }

    public SelenideAppiumElement getProductMenuButton() {
        return productMenuButton;
    }

    public SelenideAppiumElement getRemoveProductButton() {
        return removeProductButton;
    }
}
