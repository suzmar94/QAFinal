package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HranaIPicePage extends BaseHelper {

    @FindBy(className = "col-left-ap")
    WebElement wrapper;

    public HranaIPicePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private void konobaAkusticOption() {
        wdWait.until(ExpectedConditions.visibilityOf(wrapper));
        WebElement wrapp = wrapper.findElement(By.className("subcategories"));
        List<WebElement> subcategory = wrapp.findElements(By.tagName("a"));
        WebElement konobaAkustik = subcategory.get(3);
//        System.out.println("tekst odabrane opcije je:"+ konobaAkustik.getText());
        js.executeScript("arguments[0].click();", konobaAkustik);
    }
    public void konobaAkustikCategory() {
        konobaAkusticOption();
    }

}
