package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.ProductPage;

import static com.codeborne.selenide.Condition.visible;

@Log4j2
public class ProductSteps {
    ProductPage productPage = new ProductPage();

    @Step
    public void clickAddToCartButton() {
        log.info("Click 'add to cart' button");
        productPage.getAddToCartButton().shouldBe(visible).click();
    }
}
