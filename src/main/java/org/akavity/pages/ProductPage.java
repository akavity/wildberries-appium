package org.akavity.pages;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.appium.SelenideAppium.$;

public class ProductPage {
    private final SelenideAppiumElement addToCartButton = $(AppiumBy.xpath("//android.widget.TextView[@text='В корзину']/.."));

    public SelenideAppiumElement getAddToCartButton() {
        return addToCartButton;
    }
}
