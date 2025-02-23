package org.akavity.mobile.android.driver;

import java.util.HashMap;

public class AppiumUtils {
    private static final HashMap<String, Object> apSettings = new HashMap<>();

    static {
        apSettings.put("ignoreUnimportantViews", false);
        apSettings.put("allowInvisibleElements", true);
    }

    public static HashMap<String, Object> getAppiumSettings() {
        return apSettings;
    }
}
