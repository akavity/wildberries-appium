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
        // Создаётся объект File
        File app = new File("build/apps", filename);
        // Проверяется, существует ли уже файл
        if (app.exists()) {
            log.info("Using pre-downloaded app: {}", app.getAbsolutePath());
            return app;
        }
        // Создаётся директория, если её нет
        if (!app.getParentFile().exists() && !app.getParentFile().mkdirs()) {
            // Если создать её не удаётся, выбрасывается исключение.
            throw new RuntimeException("Failed to create dir " + app.getParentFile().getAbsolutePath());
        }
        // Формируется URL для загрузки файла.
        String url = remoteFilePath + filename;
        log.info("Downloading app {} to {}...", url, app.getAbsolutePath());
        // Загружается файл через поток.
        // Открывается поток (InputStream) для чтения файла по URL.
        // Метод copyInputStreamToFile(in, app) копирует данные из потока в локальный файл.
        // Если происходит ошибка (IOException), выбрасывается исключение с сообщением
        try (InputStream in = new URL(url).openStream()) {
            copyInputStreamToFile(in, app);
        } catch (IOException e) {
            throw new RuntimeException("Failed to download " + filename + " to " + app.getAbsolutePath(), e);
        }
        return app;
    }
}
