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
    public Double getProductPrice() {
        Double price = utils.extractPriceFromText(profilePage.getPriceField().getText()).doubleValue();
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

    @Step
    public void linkCard() {
        log.info("Click \"Link card\" button");
        profilePage.getLinkCardButton().click();
    }

    @Step
    public void enterCardNumber(String number) {
        log.info("Enter new card number: {}", number);
        profilePage.getCardNumberField().setValue(number);
    }

    @Step
    public void enterValidPeriod(String data) {
        log.info("Enter valid period: {}", data);
        profilePage.getValidPeriodField().setValue(data);
    }

    @Step
    public void enterCVV(String cvv) {
        log.info("Enter cvv: {}", cvv);
        profilePage.getCvvField().setValue(cvv);
    }

    @Step
    public boolean isNewCardDisplayed(String number) {
        utils.sleep();
        boolean result = profilePage.getProfileElement(number).isDisplayed();
        log.info("Is part of number displayed {}: {}", number, result);
        return result;
    }
}
