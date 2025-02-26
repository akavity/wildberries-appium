package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.SelenideAppiumElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.appium.SelenideAppium.$;

public class ProfilePage {
    public SelenideAppiumElement getProfileElement(String name) {
        return $(By.xpath("//android.widget.TextView[contains(@text,'" + name + "')]/.."));
    }

    public SelenideElement getCurrencyButton(String sign) {
        return $(By.xpath("//android.widget.TextView[@text='" + sign + "']"));
    }
}
