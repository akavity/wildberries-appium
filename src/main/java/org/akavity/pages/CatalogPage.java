package org.akavity.pages;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import static com.codeborne.selenide.appium.SelenideAppium.$;

public class CatalogPage {
    private final SelenideAppiumElement titleField = $(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.wildberries.ru:id/toolbarTitle']"));

    public SelenideAppiumElement getSubsectionButton(String text) {
        return $(AppiumBy.xpath("//android.view.View[@resource-id='" + text + "']"));
    }

    public SelenideAppiumElement getTrendSubsectionButton(String text) {
        return $(AppiumBy.xpath("//android.widget.TextView[@text='" + text + "']"));
    }

    public SelenideAppiumElement getTrend(String name) {
        return $(By.xpath("//android.widget.TextView[@text='Тренд']/..//android.view.View[@content-desc='" + name + "']/.."));
    }

    public SelenideAppiumElement getTrendTitle(String title) {
        return $(AppiumBy.xpath("//android.widget.TextView[@text='" + title + "']"));
    }

    public SelenideAppiumElement getTitleField() {
        return titleField;
    }
}
