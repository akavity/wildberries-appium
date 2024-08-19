package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.TabBarPage;

@Log4j2
public class TabBarSteps {

    TabBarPage tabBarPage = new TabBarPage();

    @Step
    public void clickHomeButton() {
        log.info("Click the Home button on the tab bar.");
        tabBarPage.getHomeButton().click();
    }

    @Step
    public void clickCatalogButton() {
        log.info("Click the Catalog button on the tab bar.");
        tabBarPage.getCatalogButton().click();
    }
}
