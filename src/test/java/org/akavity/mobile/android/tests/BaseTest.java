package org.akavity.mobile.android.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.appium.SelenideAppium;
import org.akavity.mobile.ITTest;
import org.akavity.mobile.android.driver.ci.CiAndroidDriverWithApp;
import org.akavity.mobile.android.driver.local.LocalAndroidDriverWithApp;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static org.akavity.mobile.android.driver.AppiumUtils.isCi;

public class BaseTest extends ITTest {   //  extends ITTest
    @BeforeMethod
    public static void setup() {
        closeWebDriver();
        Configuration.browser = isCi() ? CiAndroidDriverWithApp.class.getName() : LocalAndroidDriverWithApp.class.getName();
       SelenideAppium.launchApp();
       // SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true));
//        Configuration.timeout = 10_000;
//        Configuration.pageLoadTimeout = -1;
//        Configuration.remoteConnectionTimeout = Duration.ofSeconds(10).toMillis();
//        Configuration.remoteReadTimeout = ofMinutes(5).toMillis();
//        HttpClientTimeouts.defaultLocalReadTimeout = ofMinutes(4);
//        HttpClientTimeouts.defaultLocalConnectTimeout = ofMinutes(3);
    }
}
