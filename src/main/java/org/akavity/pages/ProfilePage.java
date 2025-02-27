package org.akavity.pages;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.appium.SelenideAppium.$;

public class ProfilePage {
    public SelenideAppiumElement getProfileElement(String name) {
        return $(AppiumBy.xpath("//android.widget.TextView[contains(@text,'" + name + "')]/.."));
    }

    public SelenideAppiumElement getCurrencyButton(String sign) {
        return $(AppiumBy.xpath("//android.widget.TextView[@text='" + sign + "']"));
    }

    // Deferred product
    private SelenideAppiumElement priceField = $(AppiumBy.id("com.wildberries.ru:id/priceValue"));
    private SelenideAppiumElement productName = $(AppiumBy.id("com.wildberries.ru:id/item_title"));
    private SelenideAppiumElement deleteButton = $(AppiumBy.id("com.wildberries.ru:id/deleteButton"));
    private SelenideAppiumElement productCountField = $(AppiumBy.id("com.wildberries.ru:id/productCount"));
    private SelenideAppiumElement yesButton = $(AppiumBy.xpath("//android.widget.Button[@text='ДА']"));

    public SelenideAppiumElement getPriceField() {
        return priceField;
    }

    public SelenideAppiumElement getProductName() {
        return productName;
    }

    public SelenideAppiumElement getDeleteButton() {
        return deleteButton;
    }

    public SelenideAppiumElement getProductCountField() {
        return productCountField;
    }

    public SelenideAppiumElement getYesButton() {
        return yesButton;
    }
}
