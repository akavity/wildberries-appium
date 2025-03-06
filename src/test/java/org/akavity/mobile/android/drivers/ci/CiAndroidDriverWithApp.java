package org.akavity.mobile.android.drivers.ci;

public class CiAndroidDriverWithApp extends CiAndroidDriverProvider {
    @Override
    protected String getApplicationUnderTest() {
        return "D:/stady/QA automation engineer/IT-Academy/class 15/wildberries.ru.apk"; // github actions
    }
}
