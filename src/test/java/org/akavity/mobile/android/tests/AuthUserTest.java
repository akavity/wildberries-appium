package org.akavity.mobile.android.tests;

import org.akavity.annotations.TestData;
import org.akavity.models.CurrencyData;
import org.akavity.models.FavorProductData;
import org.akavity.steps.HomeSteps;
import org.akavity.steps.ProductListSteps;
import org.akavity.steps.ProfileSteps;
import org.akavity.steps.TabBarSteps;
import org.akavity.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthUserTest extends BaseLocalTest {
    TabBarSteps tabBarSteps = new TabBarSteps();
    ProfileSteps profileSteps = new ProfileSteps();
    ProductListSteps productListSteps = new ProductListSteps();
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

    @TestData(jsonFile = "favorProductData", model = "FavorProductData")
    @Test(description = "Add a product to favorite", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void addProductToFavorite(FavorProductData favor) {
        tabBarSteps.clickHomeButton();
        String productBrandName = productListSteps.getProductBrand();
        Number productPrice = productListSteps.getPriceFirstProduct();
        productListSteps.addProductToFavorite();
        tabBarSteps.clickProfileButton();
        profileSteps.clickProfileElement(favor.getProfileElement());
        Number deferredProductPrice = profileSteps.getProductPrice();
        String deferredProductName = profileSteps.getProductName();

        Assert.assertTrue(deferredProductName.contains(productBrandName));
        Assert.assertEquals(productPrice, deferredProductPrice);
    }

    @TestData(jsonFile = "favorProductData", model = "FavorProductData")
    @Test(dependsOnMethods = "addProductToFavorite", description = "Remove the product from favorite", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void removeProductFromFavorite(FavorProductData favor) {
        tabBarSteps.clickProfileButton();
        profileSteps.clickProfileElement(favor.getProfileElement());
        profileSteps.deleteFavorProduct();
        profileSteps.clickYesButton();

        Assert.assertTrue(profileSteps.isFavorListEmpty());
    }
}
