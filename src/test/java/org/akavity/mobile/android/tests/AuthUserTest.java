package org.akavity.mobile.android.tests;

import org.akavity.annotations.TestData;
import org.akavity.models.CurrencyData;
import org.akavity.steps.HomeSteps;
import org.akavity.steps.ProfileSteps;
import org.akavity.steps.TabBarSteps;
import org.akavity.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthUserTest extends BaseLocalTest {
    TabBarSteps tabBarSteps = new TabBarSteps();
    ProfileSteps profileSteps = new ProfileSteps();
    HomeSteps homeSteps = new HomeSteps();

    @TestData(jsonFile = "currencyData", model = "CurrencyData")
    @Test(description = "Select a currency", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectCurrency(CurrencyData currency) {
        tabBarSteps.clickProfileButton();
        profileSteps.clickProfileElement(currency.getProfileElement());
        profileSteps.selectCurrency(currency.getCurrency());
        tabBarSteps.clickHomeButton();

        Assert.assertTrue(homeSteps.checkCurrencySign(currency.getSign()));
    }
}
