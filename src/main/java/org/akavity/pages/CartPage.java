package org.akavity.pages;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.appium.SelenideAppium.$;

public class CartPage {
    private final SelenideAppiumElement emptyCartField = $(AppiumBy.xpath("//android.widget.TextView[contains(@text,'корзине пусто')]"));
    private final SelenideAppiumElement productNameField = $(AppiumBy.xpath("//android.widget.TextView[@resource-id='productName']"));

    public SelenideAppiumElement getEmptyCartField() {
        return emptyCartField;
    }

    public SelenideAppiumElement getProductNameField() {
        return productNameField;
    }
}
