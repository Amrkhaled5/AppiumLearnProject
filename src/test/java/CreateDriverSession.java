package org.appium.first; // Use your actual package name

import com.beust.ah.A;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

// Correct static import for PLATFORM_NAME
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

public class CreateDriverSession {

    private static final String DEVICE_NAME = "appium:deviceName";
    private static final String AUTOMATION_NAME = "appium:automationName";
    private static final String UDID = "appium:udid";
    private static final String APP = "appium:app";
    private static final String NEWCOMMANDTIMEOUT = "appium:newCommandTimeout";

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(PLATFORM_NAME, "Android");
        caps.setCapability(DEVICE_NAME, "medium_phone");
        caps.setCapability(AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(UDID, "emulator-5554");
        caps.setCapability(NEWCOMMANDTIMEOUT, 300);

        String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";

        System.out.println("Looking for App at: " + appUrl);


         //when you will download app
         caps.setCapability(APP, appUrl);

        //when app already exist
        // CORRECT: This opens the ApiDemos app
        //caps.setCapability("appium:appPackage", "io.appium.android.apis");
        //caps.setCapability("appium:appActivity", "io.appium.android.apis.accessibility.CustomViewAccessibilityActivity");
        URL url = new URL("http://0.0.0.0:4723");
        AppiumDriver driver = new AndroidDriver(url, caps);
        System.out.println("Session ID: " + driver.getSessionId());

        // Find Elements
//        WebElement element1 = (WebElement) driver.findElement(AppiumBy.accessibilityId("Accessibility"));
//        System.out.println(element1.getText());

//        By myElement1=AppiumBy.androidUIAutomator("new UiSelector().text(\"Accessibility\")");
//        driver.findElement(myElement1).getText();
        //uiAutomator by text
//        WebElement myElement1=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Accessibility\")"));
//        System.out.println(myElement1.getText());
//
//        //uiAutomator by className
//        List<WebElement> myElement2= driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\")"));
//        System.out.println(myElement2.get(2).getText());
//
//        //uiAutomator by description
//        WebElement myElement3= driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"Accessibility\")"));
//        System.out.println(myElement3.getText());
//
//        //uiAutomator by ResourceDI
//        List<WebElement> myElement4= driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/text1\")"));
//        System.out.println(myElement4.get(1).getText());


        // real Test
//        By viewsButton= AppiumBy.accessibilityId("Views");
//        By testButton=AppiumBy.accessibilityId("TextFields");
//        By editText=AppiumBy.id("io.appium.android.apis:id/edit");
//
//        driver.findElement(viewsButton).click();
//        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
//                "left", 100,
//                "top", 300,
//                "width", 800,
//                "height", 1500,
//                "direction", "up",
//                "percent", 0.75
//        ));
//
//        driver.findElement(testButton).click();
//        driver.findElement(editText).sendKeys("Amr");
//        Thread.sleep(2000);
//        driver.findElement(editText).clear();

        // Gestures




    }

    public static void longClickGestures(AppiumDriver driver){
        By viewsButton= AppiumBy.accessibilityId("Views");
        By dragDropButton=AppiumBy.accessibilityId("Drag and Drop");
        By longClickElement=AppiumBy.id("");

        driver.findElement(viewsButton).click();
        driver.findElement(dragDropButton).click();
        WebElement element=driver.findElement(longClickElement);

        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "duration",1000
        ));
    }
}