package org.akavity.mobile.android.driver.ci;

public class CiAndroidDriverWithApp extends AndroidDriverProvider {
    @Override
    protected String getApplicationUnderTest() {
        return "https://raw.githubusercontent.com/akavity/wildberries-appium/feature/src/main/java/org/akavity/apps/";
    }
}
