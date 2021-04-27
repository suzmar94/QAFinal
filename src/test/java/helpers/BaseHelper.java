package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;

public class BaseHelper {

    protected static WebDriver driver;
    protected static WebDriverWait wdWait;
    protected static JavascriptExecutor js;

    static {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
//        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        driver = new ChromeDriver(options);
        wdWait = new WebDriverWait(driver, 20);
        js = (JavascriptExecutor) driver;
    }


    public static WebElement returnElementAttValue(String attributeName, String attributeValue) {
        String selector = "[" + attributeName + "=" + attributeValue + "]";
        WebElement element = driver.findElement(By.cssSelector(selector));
        return element;
    }


}
