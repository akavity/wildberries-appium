package org.akavity.pages;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.appium.SelenideAppium.$;

public class ProfilePage {
    public SelenideAppiumElement linkCardButton = $(AppiumBy.xpath("//android.widget.TextView[@text='Привязать карту']"));

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

    // Link new card
    private SelenideAppiumElement cardNumberField = $(AppiumBy.xpath("//android.widget.TextView[@text='Номер карты']/.."));
    private SelenideAppiumElement validPeriodField = $(AppiumBy.xpath("//android.widget.TextView[@text='Срок действия']/.."));
    private SelenideAppiumElement cvvField = $(AppiumBy.xpath("//android.widget.TextView[@text='CVV / CVC']/.."));
    private SelenideAppiumElement saveCardButton = $(AppiumBy.xpath("//android.widget.Button"));

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

    public SelenideAppiumElement getLinkCardButton() {
        return linkCardButton;
    }

    public SelenideAppiumElement getCardNumberField() {
        return cardNumberField;
    }

    public SelenideAppiumElement getValidPeriodField() {
        return validPeriodField;
    }

    public SelenideAppiumElement getCvvField() {
        return cvvField;
    }

    public SelenideAppiumElement getSaveCardButton() {
        return saveCardButton;
    }
}
