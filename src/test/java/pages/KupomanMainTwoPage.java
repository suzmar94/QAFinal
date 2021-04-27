package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class KupomanMainTwoPage extends BaseHelper {

    @FindBy(className = "sub-menu__items_wrapper")
    WebElement optionsWrapper;

    public KupomanMainTwoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private void navigateToPage() {
        driver.get("https://www.kupoman.rs/");
    }
    private void hranaIPiceOption() {
        List<WebElement> targetOptionWrapper = optionsWrapper.findElements(By.tagName("a"));
        WebElement targetOption = targetOptionWrapper.get(5);
//        System.out.println("tekst opcije je:"+targetOption.getText());
        targetOption.click();
    }
    public void clickOnHranaIPice() {
        navigateToPage();
        hranaIPiceOption();
    }

}
