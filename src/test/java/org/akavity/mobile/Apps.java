package org.akavity.mobile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class Apps {
    private static final Logger log = LoggerFactory.getLogger(Apps.class);
    private static final String WILDBERRIES_URL = "https://raw.githubusercontent.com/akavity/wildberries-appium/feature/src/main/java/org/akavity/apps/";

    public static File downloadAndroidApp() {
        return downloadSampleApp(WILDBERRIES_URL, "wildberries.ru.apk");
    }

    private static File downloadSampleApp(String remoteFilePath, String filename) {
        File app = new File("build/apps", filename);
        if (app.exists()) {
            log.info("Using pre-downloaded app: {}", app.getAbsolutePath());
            return app;
        }
        if (!app.getParentFile().exists() && !app.getParentFile().mkdirs()) {
            throw new RuntimeException("Failed to create dir " + app.getParentFile().getAbsolutePath());
        }
        String url = remoteFilePath + filename;
        log.info("Downloading app {} to {}...", url, app.getAbsolutePath());
        try (InputStream in = new URL(url).openStream()) {
            copyInputStreamToFile(in, app);
        } catch (IOException e) {
            throw new RuntimeException("Failed to download " + filename + " to " + app.getAbsolutePath(), e);
        }
        return app;
    }
}
