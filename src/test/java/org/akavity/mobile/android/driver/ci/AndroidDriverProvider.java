package org.akavity.mobile.android.driver.ci;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.jspecify.annotations.NonNull;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;

import static org.akavity.mobile.android.driver.AppiumUtils.*;

public abstract class AndroidDriverProvider implements WebDriverProvider {
    @Override
    @NonNull
    public WebDriver createDriver(@NonNull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setPlatformName("Android");
        options.setDeviceName("Pixel 8 Pro");
        options.setPlatformVersion("14.0");
        options.setCapability("bstack:options", getBrowserstackOptions());
        //options.setCapability("appium:settings", getAppiumSettings());
        options.setFullReset(false);
       // options.setApp("D:/stady/QA automation engineer/IT-Academy/class 15/wildberries.ru.apk");
        options.setApp(getApplicationUnderTest());
        try {
            return new AndroidDriver(browserstackUrl(), options);
        } catch (SessionNotCreatedException e) {
            return new AndroidDriver(browserstackUrl(), options);
        }
    }

    protected abstract String getApplicationUnderTest();

}
