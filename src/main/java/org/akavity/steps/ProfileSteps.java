package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.ProfilePage;

@Log4j2
public class ProfileSteps {
    ProfilePage profilePage = new ProfilePage();

    @Step
    public void clickProfileElement(String name) {
        log.info("Click a profile element: {}", name);
        profilePage.getProfileElement(name)
                .scrollTo()
                .click();
    }

    @Step
    public void selectCurrency(String sign) {
        log.info("Select a currency: {}", sign);
        profilePage.getCurrencyButton(sign).click();
    }
}
