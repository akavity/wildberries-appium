package org.akavity;

import org.akavity.steps.CatalogSteps;
import org.akavity.steps.TabBarSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WBTest extends BaseTest {

    TabBarSteps tabBarSteps = new TabBarSteps();
    CatalogSteps catalogSteps = new CatalogSteps();

    @Test
    public void moveThroughCatalog() {
        tabBarSteps.clickCatalogButton();
        catalogSteps.clickSectionButton("Женщинам");
        catalogSteps.clickSubsectionButton("Брюки");
        catalogSteps.clickNextSubsectionButton("no");

        Assert.assertTrue(catalogSteps.extractTextFromTitle().equals("Брюки"));
    }
}
