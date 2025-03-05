package org.akavity.mobile.android.driver.local;

import java.io.File;

import static org.akavity.mobile.Apps.downloadAndroidApp;

public class LocalAndroidDriverWithApp extends LocalAndroidDriverProvider {
    @Override
    protected File getApplicationUnderTest() {
        return downloadAndroidApp();
    }
}
