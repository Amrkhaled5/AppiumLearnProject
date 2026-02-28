import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileCommand;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;



public class CreateBrawserSession {

    private static final String DEVICE_NAME = "appium:deviceName";
    private static final String AUTOMATION_NAME = "appium:automationName";
    private static final String UDID = "appium:udid";
    private static final String APP = "appium:app";
    private static final String NEWCOMMANDTIMEOUT = "appium:newCommandTimeout";
    private static final String BROWSER_NAME = "appium:browserName";


    public static AppiumDriver initializeDriver(String PlatformName) throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(PLATFORM_NAME, "Android");
        URL url = new URL("http://0.0.0.0:4723");

        switch (PlatformName){
            case "Android":
                caps.setCapability(DEVICE_NAME, "medium_phone");
                caps.setCapability(AUTOMATION_NAME, "UiAutomator2");
                caps.setCapability(UDID, "emulator-5554");
                caps.setCapability(NEWCOMMANDTIMEOUT, 300);

                // For DriverSession
//                String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
//                        + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
//                caps.setCapability(APP, appUrl);

                //For BrowserSession
                caps.setCapability(BROWSER_NAME, "Chrome");

                return new AndroidDriver(url,caps);
            default:
                throw new Exception("Invalid Platform Name: " + PlatformName);
        }

        //when app already exist
        // CORRECT: This opens the ApiDemos app
//        caps.setCapability("appium:appPackage", "io.appium.android.apis");
//        caps.setCapability("appium:appActivity", "io.appium.android.apis.accessibility.CustomViewAccessibilityActivity");


    }
}
