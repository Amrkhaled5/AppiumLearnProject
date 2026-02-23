import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options; // 1. New Import

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverSessionOption {

    public static void main(String[] args) throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("medium_phone");
        options.setAutomationName("UiAutomator2");
        options.setUdid("RKCX600RW6D");

        // Construct path
        String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
        System.out.println("Looking for App at: " + appUrl);
        options.setApp(appUrl);
        URL url = new URL("http://0.0.0.0:4723");
        AppiumDriver driver = new AndroidDriver(url, options);
        System.out.println("Session ID: " + driver.getSessionId());
    }
}