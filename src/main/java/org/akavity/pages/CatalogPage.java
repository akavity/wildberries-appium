package org.akavity.pages;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.appium.SelenideAppium.$;

public class CatalogPage {

    private final SelenideAppiumElement titleField = $(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.wildberries.ru:id/toolbarTitle']"));


    public SelenideAppiumElement getSectionButton(String text) {
        return $(AppiumBy.xpath("//android.view.View[@content-desc='" + text + "']"));
    }

    public SelenideAppiumElement getSubsectionButton(String text) {
        return $(AppiumBy.xpath("//android.view.View[@resource-id='" + text + "']"));
    }

    public SelenideAppiumElement getTitleField() {
        return titleField;
    }

}
