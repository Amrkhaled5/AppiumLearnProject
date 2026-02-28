import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutomateBrowser {
    By menuButton= AppiumBy.xpath("//span[text()='Menu']");
    By Vechicles= AppiumBy.xpath("//button[@id=\"dx-nav-item--vehicles\"]");
    By MoelX= AppiumBy.xpath("//h3[text()='Model X']/following-sibling::div/a[text()='Order']");
    By Payment= AppiumBy.xpath("//div[@id='PAYMENT']");
    By OrederwithCard= AppiumBy.xpath("//button[@class='tds-btn tds-btn--secondary btn-creditcard  undefined']");
    By firstName= AppiumBy.xpath("//input[@id='FIRST_NAME']");

    public static void main(String[] args) throws Exception {
        AppiumDriver driver= CreateBrawserSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.tesla.com");

        driver.findElement(new AutomateBrowser().menuButton).click();
        driver.findElement(new AutomateBrowser().Vechicles).click();
        driver.findElement(new AutomateBrowser().MoelX).click();


        WebElement paymentElement = driver.findElement(new AutomateBrowser().Payment);
        driver.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", paymentElement);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement orderCardButton = wait.until(ExpectedConditions.presenceOfElementLocated(new AutomateBrowser().OrederwithCard));
        driver.executeScript("arguments[0].click();", orderCardButton);

        WebElement FirstNameElement = driver.findElement(new AutomateBrowser().firstName);
        driver.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", FirstNameElement);
        FirstNameElement.sendKeys("Amr Khaled");


    }
}

//        WebElement FirstNameElement = driver.findElement(new AutomateBrowser().firstName);
//        driver.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", FirstNameElement);