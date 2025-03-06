package org.akavity.mobile.android.drivers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class AppiumUtils {
    private static final HashMap<String, Object> apSettings = new HashMap<>();
    private static final HashMap<String, Object> bstackOptions = new HashMap<>();

    static {
//        bstackOptions.put("userName", "nametest");
//        bstackOptions.put("accessKey", System.getProperty("key"));
//        bstackOptions.put("appiumVersion", "2.6.0");
//        bstackOptions.put("projectName", "Wb-Appium");
//        bstackOptions.put("interactiveDebugging", true);
    }

    static {
        apSettings.put("ignoreUnimportantViews", false);
        apSettings.put("allowInvisibleElements", true);
    }

    public static HashMap<String, Object> getAppiumSettings() {
        return apSettings;
    }

    public static HashMap<String, Object> getBrowserstackOptions() {
        return bstackOptions;
    }

    public static URL browserstackUrl() {
        try {
            return new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isCi() {
        return System.getenv().containsKey("CI");
    }
}
