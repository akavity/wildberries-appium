package org.akavity.pages;

import com.codeborne.selenide.appium.SelenideAppiumCollection;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.appium.SelenideAppium.$$;

public class ProductListPage {
    private final SelenideAppiumCollection products = $$(AppiumBy.xpath("(//android.view.ViewGroup[contains(@resource-id,'itemLayout')])"));

    public SelenideAppiumCollection getFigures(String figure) {
        return $$(AppiumBy.xpath("//android.widget.TextView[contains(@content-desc,'" + figure + "')]"));
    }

    public SelenideAppiumCollection getProducts() {
        return products;
    }
}
