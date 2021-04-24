package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class KupomanBeautyAndWellnessPage extends BaseHelper {

    @FindBy(className="sub-menu__items_wrapper")
    WebElement optionsWrapper;

    public KupomanBeautyAndWellnessPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private void navigateToPage(){
        driver.get("https://www.kupoman.rs/");
    }
    private void lepotaIWellnessOption(){
        List<WebElement> targetOptionWrapper = optionsWrapper.findElements(By.tagName("a"));
        WebElement targetOption = targetOptionWrapper.get(4);
//        System.out.println("tekst opcije je:"+targetOption.getText());
        targetOption.click();
    }
    public void clickOnlepotaIWellness(){
        navigateToPage();
        lepotaIWellnessOption();
    }
}
