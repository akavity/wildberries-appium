package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.HomePage;

@Log4j2
public class HomeSteps {
    HomePage homePage = new HomePage();

    @Step
    public void enterTextToSearch(String text) {
        log.info("Look for text: {}", text);
        homePage.getSearchField().click();

    }

    @Step
    public void clickSuggest(String text) {
        log.info("Click suggest: {}", text);
        homePage.getSuggest(text).click();
    }
}
