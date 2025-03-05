package org.akavity.mobile.android.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.appium.SelenideAppium;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.webdriver.HttpClientTimeouts;
import io.qameta.allure.selenide.AllureSelenide;
import org.akavity.mobile.android.driver.ci.CiAndroidDriverWithApp;
import org.akavity.mobile.android.driver.local.LocalAndroidDriverWithApp;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static java.time.Duration.ofMinutes;
import static org.akavity.mobile.android.driver.AppiumUtils.isCi;

public class BaseLocalTest {   //  extends ITTest
    @BeforeMethod
    public static void setup() {
        closeWebDriver();
        Configuration.browser = isCi() ? CiAndroidDriverWithApp.class.getName() : LocalAndroidDriverWithApp.class.getName();
        SelenideAppium.launchApp();
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true));
        Configuration.timeout = 10_000;
        Configuration.pageLoadTimeout = -1;
        Configuration.remoteConnectionTimeout = Duration.ofSeconds(10).toMillis();
        Configuration.remoteReadTimeout = ofMinutes(5).toMillis();
        HttpClientTimeouts.defaultLocalReadTimeout = ofMinutes(4);
        HttpClientTimeouts.defaultLocalConnectTimeout = ofMinutes(3);
    }
}
