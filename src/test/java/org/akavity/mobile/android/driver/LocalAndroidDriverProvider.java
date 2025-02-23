package org.akavity.mobile.android.driver;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.jspecify.annotations.NonNull;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.akavity.mobile.android.driver.AppiumUtils.getAppiumSettings;

public abstract class LocalAndroidDriverProvider implements WebDriverProvider {
    @NonNull
    public WebDriver createDriver(@NonNull Capabilities capabilities) {
        UiAutomator2Options options = getUiAutomator2Options();
        options.setApp(getApplicationUnderTest().getAbsolutePath());
        try {
            return new AndroidDriver(url(), options);
        } catch (SessionNotCreatedException e) {
            return new AndroidDriver(url(), options);
        }
    }

    protected abstract File getApplicationUnderTest();

    protected UiAutomator2Options getUiAutomator2Options() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setPlatformName("Android");
        options.setDeviceName("Pixel 8 Pro");
        options.setPlatformVersion("14.0");
//        options.setNewCommandTimeout(Duration.ofSeconds(11)); //
//        options.setFullReset(false);                          //
        options.noReset();                                    //
        options.setCapability("appium:settings", getAppiumSettings());
        return options;
    }

    private static URL url() {
        try {
            return new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
