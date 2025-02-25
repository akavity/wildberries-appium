package org.akavity.utils;

import com.codeborne.selenide.appium.AppiumDriverRunner;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

public class Utils {
    private int START_X = 1000; //
    private int END_X = 180;    //

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

    public void pressElement(int xOffset, int yOffset) {
        TouchAction touch = new TouchAction(AppiumDriverRunner.getAndroidDriver());
        touch.press(PointOption.point(xOffset, yOffset)).release().perform();
    }

    public void swipeElementLeft(int y) {
        TouchAction touch = new TouchAction(AppiumDriverRunner.getAndroidDriver());
        touch.press(PointOption.point(START_X, y))      // startY
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(END_X, y))    // endY
                .release().perform();
    }
}
