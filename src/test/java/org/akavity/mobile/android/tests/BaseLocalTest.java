package org.akavity.mobile.android.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.appium.SelenideAppium;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.akavity.mobile.android.driver.LocalAndroidDriverWithApp;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseLocalTest {   //  extends ITTest
    @BeforeMethod
    public static void setup() {
        closeWebDriver();
        Configuration.browser =  LocalAndroidDriverWithApp.class.getName();
        SelenideAppium.launchApp();
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true));
    }
}
