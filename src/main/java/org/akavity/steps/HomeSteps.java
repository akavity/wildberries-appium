package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.HomePage;
import org.akavity.utils.Utils;

@Log4j2
public class HomeSteps {
    HomePage homePage = new HomePage();
    Utils utils = new Utils();

    @Step
    public void setTextToSearch(String text) {
        log.info("Set {} to search", text);
        homePage.getSearchField().click();
        homePage.getSearchField().setValue(text);
    }

    @Step
    public void enterTextToSearch(String text) {
        log.info("Set {} to search and press enter", text);
        homePage.getSearchField().click();
        homePage.getSearchField().setValue(text);
        utils.pressSearchButton();
    }

    @Step
    public void clickSuggest(String text) {
        log.info("Click suggest: {}", text);
        homePage.getSuggest(text).click();
    }
}
