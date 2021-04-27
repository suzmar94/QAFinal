package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class FirstMealPage extends BaseHelper {

    @FindBy(className = "row-eq-height")
    WebElement offersWrapper;

    public FirstMealPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void firstMeal() {
        wdWait.until(ExpectedConditions.visibilityOf(offersWrapper));
        List<WebElement> offerSelect = offersWrapper.findElements(By.className("col-sm-6"));
//        System.out.println("velicina je:"+offerSelect.size());
        WebElement firstOffer = offerSelect.get(0);
//        System.out.println("tekst je:"+firstOffer.getText());
        firstOffer.click();

    }

    public void firstMealClick() {
        firstMeal();

    }
}
