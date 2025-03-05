package org.akavity.mobile.android.tests;

import org.akavity.annotations.TestData;
import org.akavity.models.CurrencyData;
import org.akavity.models.FavorProductData;
import org.akavity.models.ProductQtyData;
import org.akavity.steps.*;
import org.akavity.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthUserTest extends BaseTest {
    TabBarSteps tabBarSteps = new TabBarSteps();
    ProfileSteps profileSteps = new ProfileSteps();
    ProductSteps productSteps = new ProductSteps();
    ProductListSteps productListSteps = new ProductListSteps();
    HomeSteps homeSteps = new HomeSteps();
    CartSteps cartSteps = new CartSteps();

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
    @Test(dependsOnMethods = "addProductToFavorite", description = "Remove the product from favorite",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void removeProductFromFavorite(FavorProductData favor) {
        tabBarSteps.clickProfileButton();
        profileSteps.clickProfileElement(favor.getProfileElement());
        profileSteps.deleteFavorProduct();
        profileSteps.clickYesButton();

        Assert.assertTrue(profileSteps.isFavorListEmpty());
    }

    @TestData(jsonFile = "productQtyData", model = "ProductQtyData")
    @Test(description = "Increase quantity of products in the basket", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void increaseProductQuantityInCart(ProductQtyData qty) {
        tabBarSteps.clickHomeButton();
        double productPrice = productListSteps.getPriceFirstProduct() * qty.getQty();
        productListSteps.clickFirstProduct();
        productSteps.clickAddToCartButton();
        tabBarSteps.clickCartButton();
        cartSteps.increaseProductQuantity(qty.getClicks());
        int actualQty = cartSteps.getProductQuantity();
        double cartPrice = cartSteps.getProductPrice();

        Assert.assertEquals(actualQty, qty.getQty());
        Assert.assertEquals(cartPrice, productPrice);

    }

    @TestData(jsonFile = "productQtyData", model = "ProductQtyData")
    @Test(dependsOnMethods = "increaseProductQuantityInCart", description = "Decrease quantity of products in the basket",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void decreaseProductQuantityInCart(ProductQtyData qty) {
        tabBarSteps.clickCartButton();
        double startPrice = cartSteps.getProductPrice();
        int startQty = cartSteps.getProductQuantity();
        cartSteps.decreaseProductQuantity(qty.getClicks());

        double expectedEndPrice = startPrice / qty.getQty();
        int expectedEndQty = startQty - qty.getClicks();
        double actualEndPrice = cartSteps.getProductPrice();
        int actualEndQty = cartSteps.getProductQuantity();

        Assert.assertEquals(actualEndQty, expectedEndQty);
        Assert.assertEquals(actualEndPrice, expectedEndPrice);
        cartSteps.removeProduct();
    }
}
