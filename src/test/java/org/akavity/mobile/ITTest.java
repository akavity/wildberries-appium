package org.akavity.mobile;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.appium.SelenideAppium;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.webdriver.HttpClientTimeouts;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import static java.time.Duration.ofMinutes;
import static org.akavity.mobile.android.driver.AppiumUtils.isCi;

@Log4j2
public abstract class ITTest {

//    @BeforeClass
//    static void initAppium() {
//        if (!isCi()) {
//            startAppium();
//        }
//    }

    private static void startAppium() {
        SelenideAppium.launchApp();
    }

    private static void startAllure() {
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true));
    }

    @BeforeMethod
    final void resetSettings() {
//        if (!isCi()) {
//            startAppium();
//        }
        startAllure();
        Configuration.timeout = 10_000;
        Configuration.pageLoadTimeout = -1;
        Configuration.remoteConnectionTimeout = Duration.ofSeconds(10).toMillis();
        Configuration.remoteReadTimeout = ofMinutes(5).toMillis();
        HttpClientTimeouts.defaultLocalReadTimeout = ofMinutes(4);
        HttpClientTimeouts.defaultLocalConnectTimeout = ofMinutes(3);
    }
}
