package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CatchingNumbersPage extends BaseHelper {

    @FindBy(className="subcategories__badge")
    WebElement numberInFilter;
    @FindBy(className="col-left-ap")
    WebElement wrapper;

    public String numberDisplayedInFilter;
    public String numberOfArticlesDisplayed;

    public CatchingNumbersPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private void filterNumber(){
        WebElement total = wrapper.findElement(By.className("subcategories"));
        List<WebElement> subcategory = total.findElements(By.tagName("a"));
        WebElement nadogradnja = subcategory.get(14);
        WebElement numFilter = nadogradnja.findElement(By.tagName("span"));
        System.out.println(numFilter.getText());
        numberDisplayedInFilter = numFilter.getText();
        System.out.println("broj u filteru je:"+numberDisplayedInFilter);

    }
    private void articlesTotal(){

    }
    public void articlesDisplayed(){
        filterNumber();

    }
}
