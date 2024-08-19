package org.akavity.driver;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@ParametersAreNonnullByDefault
public class AndroidDriver implements WebDriverProvider {

    @Override
    @CheckReturnValue
    @Nonnull
    public WebDriver createDriver(Capabilities capabilities) {
        Map<String, Object> map = new HashMap<>();
        map.put("ignoreUnimportantViews", false);
        map.put("allowInvisibleElements", true);

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setCapability("appium:settings", map);
        options.setPlatformName("Android");
        options.setPlatformVersion("14.0");
        options.setDeviceName("Pixel 8 Pro");
        options.setNewCommandTimeout(Duration.ofSeconds(11));
        options.setFullReset(false);
        options.noReset();
        options.setApp("D:/stady/QA automation engineer/IT-Academy/class 15/wildberries.ru.apk");

        try {
            return new io.appium.java_client.android.AndroidDriver(new URL("http://localhost:4723/wd/hub"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
