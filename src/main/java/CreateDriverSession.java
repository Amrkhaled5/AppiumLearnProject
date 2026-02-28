import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;
import java.util.Set;

// Correct static import for PLATFORM_NAME


public class CreateDriverSession {

    public static void main(String[] args) throws Exception {

        AppiumDriver driver= CreateBrawserSession.initializeDriver("Android");

        AppiumDriver newDrive= webViewGestures(driver);

        System.out.println(newDrive.findElement(By.cssSelector("body >h1")).getText());
        System.out.println(newDrive.findElement(By.xpath("//*[@id=\"i_am_a_textbox\"]")).getText());

        ((AndroidDriver) newDrive).context("NATIVE_APP");

    }
    //webview
    public static AppiumDriver webViewGestures(AppiumDriver driver) throws InterruptedException {
        By viewsButton= AppiumBy.accessibilityId("Views");
        By androidID= AppiumBy.id("android:id/list");
        By webViewButton=AppiumBy.accessibilityId("WebView");
        By urlTextField=AppiumBy.id("iio.appium.android.apis:id/url");

        driver.findElement(viewsButton).click();

        WebElement element1=driver.findElement(androidID);
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element1).getId(),
                "direction", "up",
                "percent", 0.75
        ));

        driver.findElement(webViewButton).click();

        Set<String> contexts= ((AndroidDriver)driver).getContextHandles();
        for (String contextHandle: contexts) {
            System.out.println(contextHandle);
        }
        ((AndroidDriver)driver).context(contexts.toArray()[1].toString());
        return driver;
    }

//    public static void longClickGestures(AppiumDriver driver){
//        By viewsButton= AppiumBy.accessibilityId("Views");
//        By dragDropButton=AppiumBy.accessibilityId("Drag and Drop");
//        By longClickElement=AppiumBy.id("");
//
//        driver.findElement(viewsButton).click();
//        driver.findElement(dragDropButton).click();
//        WebElement element=driver.findElement(longClickElement);
//
//        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
//                "elementId", ((RemoteWebElement) element).getId(),
//                "duration",1000
//        ));
//    }
}

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
