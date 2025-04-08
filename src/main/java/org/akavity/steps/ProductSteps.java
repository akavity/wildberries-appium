package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.ProductPage;
import org.akavity.utils.Utils;

import static com.codeborne.selenide.Condition.visible;

@Log4j2
public class ProductSteps {
    ProductPage productPage = new ProductPage();
    Utils utils = new Utils();

    @Step
    public void clickAddToCartButton() {
        log.info("Click 'add to cart' button");
        productPage.getAddToCartButton().shouldBe(visible).click();
    }

    @Step
    public void clickReviewButton() {
        utils.sleep(1500);
        log.info("Click review button");
        productPage.getReviewButton().scrollTo().click();
    }

    @Step
    public boolean isReviewsTitleDisplayed() {
        boolean result = productPage.getReviewsAndRatingsTitle().isDisplayed();
        log.info("Is title reviews and ratings displayed: {}", result);
        return result;
    }

    @Step
    public void clickQuestionsButton() {
        utils.sleep(1500);
        log.info("Click questions button");
        productPage.getQuestionsButton().scrollTo().click();
    }

    @Step
    public boolean isQuestionsTitleDisplayed() {
        boolean result = productPage.getQuestionsTitle().isDisplayed();
        log.info("Is title questions displayed: {}", result);
        return result;
    }
}
