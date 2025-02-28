package org.akavity.pages;

import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.codeborne.selenide.appium.SelenideAppium.$$;

public class HomePage {
    private final SelenideAppiumElement searchField = $(AppiumBy.xpath("//android.widget.TextView[@text='Поиск']/.."));

    private final SelenideAppiumCollection currencyFields = $$(AppiumBy.id("com.wildberries.ru:id/textCurrentPrice")); // must move to ProductList

    public SelenideAppiumElement getSearchFieldWithTex(String text) {
        return $(AppiumBy.xpath("//android.widget.EditText[@text='" + text + "']/.."));
    }

    public SelenideAppiumElement getSuggest(String text) {
        return $(AppiumBy.xpath("//android.widget.TextView[@text='" + text + "']/.."));
    }

    public SelenideAppiumElement getTextField(String text) {
        return $(AppiumBy.xpath("//android.widget.EditText[@text='" + text + "']"));
    }

    public SelenideAppiumElement getSearchField() {
        return searchField;
    }

    public SelenideAppiumCollection getCurrencyFields() {
        return currencyFields;
    }
}
