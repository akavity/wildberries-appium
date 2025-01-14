package org.akavity;

import org.akavity.annotations.TestData;
import org.akavity.models.CartData;
import org.akavity.models.CatalogData;
import org.akavity.models.ProductData;
import org.akavity.steps.*;
import org.akavity.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WBTest extends BaseTest {
    TabBarSteps tabBarSteps = new TabBarSteps();
    CatalogSteps catalogSteps = new CatalogSteps();
    HomeSteps homeSteps = new HomeSteps();
    ProductListSteps productListSteps = new ProductListSteps();
    ProductSteps productSteps = new ProductSteps();
    CartSteps cartSteps = new CartSteps();

    @TestData(jsonFile = "catalogData", model = "CatalogData")
    @Test(description = "Catalog navigation", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void moveThroughCatalog(CatalogData catalog) {
        tabBarSteps.clickCatalogButton();
        catalogSteps.clickSectionButton(catalog.getSection());
        catalogSteps.clickSubsectionButton(catalog.getSubsection());
        catalogSteps.clickNextSubsectionButton(catalog.getNextSubsection());

        Assert.assertEquals(catalog.getTitle(), catalogSteps.extractTextFromTitle());
    }

    @TestData(jsonFile = "productData", model = "ProductData")
    @Test(description = "Search the product", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void lookForTheProduct(ProductData product) {
        homeSteps.setTextToSearch(product.getText());
        homeSteps.clickSuggest(product.getSuggest());

        Assert.assertTrue(productListSteps.isProductDisplayed(product.getFigureText()));
    }

    @TestData(jsonFile = "cartData", model = "CartData")
    @Test(description = "Adding a product to the cart", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void addProductToCart(CartData cart) {
        homeSteps.enterTextToSearch(cart.getProductName());
        productListSteps.clickFirstAddToCartButton();
        tabBarSteps.clickCartButton();

        Assert.assertTrue(cartSteps.isTheProductDisplayed(cart.getProductName()));
    }

    @Test(dependsOnMethods = "addProductToCart", description = "Removing the product from the cart")
    public void removeProductFromCart() {
        tabBarSteps.clickCartButton();
        cartSteps.removeProduct();
        tabBarSteps.clickCartButton();

        Assert.assertTrue(cartSteps.isTheCartEmpty());
    }
}
