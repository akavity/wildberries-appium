package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.appium.SelenideAppium.$;

public class TabBarPage {
    private final SelenideAppiumElement homeButton = $(AppiumBy.xpath("//android.view.View[@resource-id='ProfileNavBar']"));
    private final SelenideAppiumElement catalogButton = $(AppiumBy.xpath("//android.view.View[@resource-id='CatNavBar']"));
    private final SelenideAppiumElement cartButton = $(AppiumBy.xpath("//android.view.View[@resource-id='CartNavBar']"));
    private final SelenideAppiumElement profileButton = $(AppiumBy.xpath("//android.view.View[@resource-id='ProfileNavBar']"));

    public SelenideElement getHomeButton() {
        return homeButton;
    }

    public SelenideElement getCatalogButton() {
        return catalogButton;
    }

    public SelenideElement getCartButton() {
        return cartButton;
    }

    public SelenideElement getProfileButton() {
        return profileButton;
    }
}
