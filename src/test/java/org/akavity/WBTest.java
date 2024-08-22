package org.akavity;

import org.akavity.steps.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WBTest extends BaseTest {
    TabBarSteps tabBarSteps = new TabBarSteps();
    CatalogSteps catalogSteps = new CatalogSteps();
    HomeSteps homeSteps = new HomeSteps();
    ProductListSteps productListSteps = new ProductListSteps();
    ProductSteps productSteps = new ProductSteps();
    CartSteps cartSteps = new CartSteps();

    @Test
    public void moveThroughCatalog() {
        tabBarSteps.clickCatalogButton();
        catalogSteps.clickSectionButton("Женщинам");
        catalogSteps.clickSubsectionButton("Брюки");
        catalogSteps.clickNextSubsectionButton("no");

        Assert.assertTrue(catalogSteps.extractTextFromTitle().equals("Брюки"));
    }

    @Test
    public void lookForTheProduct() {
        homeSteps.setTextToSearch("куртка мужская");
        homeSteps.clickSuggest("куртка мужская");

        Assert.assertTrue(productListSteps.isProductDisplayed("Куртка"));
    }

    @Test
    public void addProductToCart() {
        homeSteps.enterTextToSearch("redmi note 13");
        productListSteps.clickFirstProduct();
        productSteps.clickAddToCartButton();
        tabBarSteps.clickCartButton();

        Assert.assertTrue(cartSteps.isTheProductDisplayed("redmi note 13"));
    }
}
