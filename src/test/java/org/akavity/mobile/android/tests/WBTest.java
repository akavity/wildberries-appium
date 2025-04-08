package org.akavity.mobile.android.tests;

import org.akavity.annotations.TestData;
import org.akavity.enums.ButtonType;
import org.akavity.models.CartData;
import org.akavity.models.CatalogData;
import org.akavity.models.ProductData;
import org.akavity.models.TrendData;
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
        catalogSteps.clickSubsectionButton(catalog.getSections(), ButtonType.CATALOG);

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
        productListSteps.clickFirstButtonAddToCart();
        tabBarSteps.clickCartButton();

        Assert.assertTrue(cartSteps.checkProductName(cart.getPartOfName()));
    }

    @Test(dependsOnMethods = "addProductToCart", description = "Removing the product from the cart")
    public void removeProductFromCart() {
        tabBarSteps.clickCartButton();
        cartSteps.removeProduct();
        tabBarSteps.clickCartButton();

        Assert.assertTrue(cartSteps.isTheCartEmpty());
    }

    @TestData(jsonFile = "trendData", model = "TrendData")
    @Test(description = "Select a trend", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectTrend(TrendData trendData) {
        tabBarSteps.clickCatalogButton();
        catalogSteps.clickTrendsButton();
        catalogSteps.selectTrend(trendData.getName());
        catalogSteps.clickSubsectionButton(trendData.getSections(), ButtonType.TREND);

        Assert.assertTrue(catalogSteps.isTrendTitleDisplayed(trendData.getTitle()));
    }

    @Test(description = "View reviews and ratings")
    public void viewReviews() {
        productListSteps.clickFirstProduct();
        productSteps.clickReviewButton();

        Assert.assertTrue(productSteps.isReviewsTitleDisplayed());
    }

    @Test(description = "View questions about the product")
    public void viewQuestions() {
        productListSteps.clickFirstProduct();
        productSteps.clickQuestionsButton();

        Assert.assertTrue(productSteps.isQuestionsTitleDisplayed());
    }
}
