package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.CatalogPage;

@Log4j2
public class CatalogSteps {

    CatalogPage catalogPage = new CatalogPage();

    @Step
    public void clickSectionButton(String text) {
        log.info("Click section of catalog: {}", text);
        catalogPage.getSectionButton(text)
                .scrollTo()
                .click();
    }

    @Step
    public void clickSubsectionButton(String text) {
        log.info("Click subsection of catalog: {}", text);
        catalogPage.getSubsectionButton(text)
                .scrollTo()
                .click();
    }

    @Step
    public void clickNextSubsectionButton(String text) {
        if (text.equalsIgnoreCase("no")) {
            log.info("There isn't next subsection");
        } else {
            log.info("Click next subsection of catalog: {}", text);
            catalogPage.getSubsectionButton(text)
                    .scrollTo()
                    .click();
        }
    }

    @Step
    public String extractTextFromTitle() {
        String text = catalogPage.getTitleField().getText();
        log.info("Extract text from Title: {}", text);
        return text;
    }
}
