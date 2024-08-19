package org.akavity;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.appium.SelenideAppium;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.akavity.driver.AndroidDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    @BeforeMethod
    public void setUp() {
        WebDriverRunner.closeWebDriver();
        Configuration.browser = AndroidDriver.class.getName();
        SelenideAppium.launchApp();
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true));
    }
}
