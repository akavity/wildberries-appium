package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.TabBarPage;
import org.akavity.utils.Utils;

@Log4j2
public class TabBarSteps {
    TabBarPage tabBarPage = new TabBarPage();
    Utils utils = new Utils();

    @Step
    public void clickHomeButton() {
        log.info("Click the Home button on the tab bar");
        tabBarPage.getHomeButton().click();
        utils.sleep();
    }

    @Step
    public void clickCatalogButton() {
        log.info("Click the Catalog button on the tab bar");
        tabBarPage.getCatalogButton().click();
    }

    @Step
    public void clickCartButton() {
        log.info("Click the Cart button on the tab bar");
        tabBarPage.getCartButton().click();
    }

    @Step
    public void clickProfileButton() {
        log.info("CLick the profile button on the teb bar");
        tabBarPage.getProfileButton().click();
    }
}
