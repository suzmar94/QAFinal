package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SelectMealOfferPage extends BaseHelper {

    @FindBy(className = "detail-bar--bordered")
    WebElement priceBar;

    public SelectMealOfferPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void clickOnPrice() {
        wdWait.until(ExpectedConditions.visibilityOf(priceBar));
        WebElement divPrice = priceBar.findElement(By.tagName("div"));
        WebElement price = divPrice.findElement(By.className("detail-bar__button"));
//        System.out.println("tekst na elementu je:"+price.getText());
        js.executeScript("arguments[0].click();", price);
    }

    public void selectMealOffer() {
        clickOnPrice();
    }
}
