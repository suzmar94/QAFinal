package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AddToCartPage extends BaseHelper {

    @FindBy(className = "cart-item__counter-wrapper")
    WebElement increaseDecreaseSection;
    @FindBy(className = "d-block")
    WebElement originalPrice;
    @FindBy(className = "cart-price__count")
    WebElement originalArticlesPrice;

    public String oneUnitPrice;
    public String chosenUnitsPrice;

    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void increaseQuantity() throws InterruptedException {
        wdWait.until(ExpectedConditions.visibilityOf(increaseDecreaseSection));
        WebElement plusSignWrapper = increaseDecreaseSection.findElement(By.tagName("div"));
        List<WebElement> plusSign = plusSignWrapper.findElements(By.className("cart-item__counter-button"));
        WebElement plus = plusSign.get(1);
//        System.out.println("znak odabranog elementa je:"+plus.getText());
        js.executeScript("arguments[0].click();", plus);

//        for (int i = 0; i < 4; i++){
//            //click the button
//        js.executeScript("arguments[0].click();", plus);
//            //wait 2 seconds
//            Thread.sleep(2000);
//        }


    }

    public void oneArticlePrice() {
        List<WebElement> priceOne = originalPrice.findElements(By.tagName("span"));
        WebElement pricePrice = priceOne.get(0);
        System.out.println("Cena jednog artikla je:" + pricePrice.getText());
        oneUnitPrice = pricePrice.getText();

    }

    public void articlesPrice() {
        wdWait.until(ExpectedConditions.visibilityOf(originalArticlesPrice));
        List<WebElement> priceAll = originalArticlesPrice.findElements(By.tagName("span"));
        WebElement pricePrice = priceAll.get(0);
        System.out.println("Cena izabranog broja artikala je:" + pricePrice.getText());
        chosenUnitsPrice = pricePrice.getText();
    }

    public void addToCart() throws InterruptedException {
        increaseQuantity();
        oneArticlePrice();
        articlesPrice();

    }

}
