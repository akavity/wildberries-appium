package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.ProfilePage;
import org.akavity.utils.Utils;

@Log4j2
public class ProfileSteps {
    ProfilePage profilePage = new ProfilePage();
    Utils utils = new Utils();

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

    @Step
    public Number getProductPrice() {
        Number price = utils.extractPriceFromText(profilePage.getPriceField().getText());
        log.info("Get product price: {}", price);
        return price;
    }

    @Step
    public String getProductName() {
        String name = profilePage.getProductName().getText();
        log.info("Get product name: {}", name);
        return name;
    }

    @Step
    public void deleteFavorProduct() {
        log.info("Delete the product from favorite");
        profilePage.getDeleteButton().click();
    }

    @Step
    public void clickYesButton() {
        log.info("Click yes button");
        profilePage.getYesButton().click();
    }

    @Step
    public boolean isFavorListEmpty() {
        boolean result = !profilePage.getProductCountField().isDisplayed();
        log.info("Is list of product empty: {}", result);
        return result;
    }
}
