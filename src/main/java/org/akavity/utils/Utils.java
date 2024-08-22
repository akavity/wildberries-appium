package org.akavity.utils;

import com.codeborne.selenide.appium.AppiumDriverRunner;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class Utils {
    final int X_OFFSET = 1230;
    final int Y_OFFSET = 2735;

    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void pressSearchButton() {
        TouchAction touch = new TouchAction(AppiumDriverRunner.getAndroidDriver());
        touch.press(PointOption.point(X_OFFSET, Y_OFFSET)).release().perform();
    }
}
