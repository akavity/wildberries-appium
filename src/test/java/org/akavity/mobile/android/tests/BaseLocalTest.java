package org.akavity.mobile.android.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.appium.SelenideAppium;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.akavity.mobile.android.driver.ci.CiAndroidDriverWithApp;
import org.akavity.mobile.android.driver.local.LocalAndroidDriverWithApp;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static org.akavity.mobile.android.driver.AppiumUtils.isCi;

public class BaseLocalTest {   //  extends ITTest
    @BeforeMethod
    public static void setup() {
        closeWebDriver();
       // Configuration.browser = isCi() ? CiAndroidDriverWithApp.class.getName() : LocalAndroidDriverWithApp.class.getName();
        //Configuration.browser =  LocalAndroidDriverWithApp.class.getName();
        Configuration.browser =  CiAndroidDriverWithApp.class.getName();
        SelenideAppium.launchApp();
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true));
    }
}
