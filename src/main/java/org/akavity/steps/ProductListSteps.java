package org.akavity.steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.ProductListPage;

@Log4j2
public class ProductListSteps {

    ProductListPage productListPage = new ProductListPage();

    @Step
    public boolean isProductDisplayed(String figure) {
        SelenideElement el = productListPage.getFigures(figure).first();
        boolean result = el.getText().toLowerCase().contains(figure.toLowerCase());
        log.info("Is product {} displayed: {} - '{}'", figure, result, el.getText());
        return result;
    }
}