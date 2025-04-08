package org.akavity.pages;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.appium.SelenideAppium.$;

public class ProductPage {
    private final SelenideAppiumElement addToCartButton = $(AppiumBy.xpath("//android.widget.TextView[@text='В корзину']/.."));
    private final SelenideAppiumElement reviewButton = $(AppiumBy.xpath("//android.view.View[@resource-id='rating']"));
    private final SelenideAppiumElement reviewsAndRatingsTitle = $(AppiumBy.xpath("//android.widget.TextView[@text='Оценки и отзывы']"));
    private final SelenideAppiumElement questionsButton = $(AppiumBy.xpath("//android.view.View[@resource-id='questions']"));
    private final SelenideAppiumElement questionsTitle = $(AppiumBy.xpath("//android.widget.TextView[@text='Вопросы о товаре']"));

    public SelenideAppiumElement getAddToCartButton() {
        return addToCartButton;
    }

    public SelenideAppiumElement getReviewButton() {
        return reviewButton;
    }

    public SelenideAppiumElement getReviewsAndRatingsTitle() {
        return reviewsAndRatingsTitle;
    }

    public SelenideAppiumElement getQuestionsButton() {
        return questionsButton;
    }

    public SelenideAppiumElement getQuestionsTitle() {
        return questionsTitle;
    }
}
