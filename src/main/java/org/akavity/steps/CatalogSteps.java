package org.akavity.steps;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.enums.ButtonType;
import org.akavity.pages.CatalogPage;
import org.akavity.utils.Utils;

import static com.codeborne.selenide.appium.AppiumClickOptions.tap;

@Log4j2
public class CatalogSteps {
    private final int TREND_Y_OFFSET = 1350;
    private final int TRENDS_BUTTON_X_OFFSET = 210;
    private final int TRENDS_BUTTON_Y_OFFSET = 660;
    CatalogPage catalogPage = new CatalogPage();
    Utils utils = new Utils();

    @Step
    public String extractTextFromTitle() {
        String text = catalogPage.getTitleField().getText();
        log.info("Extract text from Title: {}", text);
        return text;
    }

    @Step
    public void selectTrend(String name) {
        SelenideAppiumElement el = catalogPage.getTrend(name);
        int count = 0;
        utils.sleep(2500);
        while (count < 6) {
            if (el.isDisplayed()) {
                log.info("The item is displayed: Click the item");
                el.click(tap());
                break;
            } else {
                log.info("The item isn't displayed: Swipe");
                utils.swipeElementLeft(TREND_Y_OFFSET);
            }
            count++;
        }
    }

    @Step
    public void clickTrendsButton() {
        log.info("Click trend button");
        utils.clickPoint(TRENDS_BUTTON_X_OFFSET, TRENDS_BUTTON_Y_OFFSET);
    }

    @Step
    public boolean isTrendTitleDisplayed(String title) {
        boolean result = catalogPage.getTrendTitle(title).isDisplayed();
        log.info("Is trend title '{}' displayed: {}", title, result);
        return result;
    }

    @Step
    public void clickSubsectionButton(String[] names, ButtonType typeButton) {
        SelenideAppiumElement el;
        log.info("Click section");
        for (String name : names) {
            log.info("Click subsection: {}", name);
            switch (typeButton) {
                case TREND:
                    el = catalogPage.getTrendSubsectionButton(name);
                    break;
                case CATALOG:
                    el = catalogPage.getSubsectionButton(name);
                    break;
                default:
                    log.warn("Unknown button type: {}", typeButton);
                    continue;
            }
            if (el == null) {
                log.warn("Element for subsection '{}' not found", name);
                continue;
            }
            el.scrollTo().click();
        }
    }
}
