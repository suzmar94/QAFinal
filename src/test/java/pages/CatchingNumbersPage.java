package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CatchingNumbersPage extends BaseHelper {

    @FindBy(className = "row-eq-height")
    WebElement divArticles;
    @FindBy(className = "col-left-ap")
    WebElement wrapper;

    public double numberDisplayedInFilter;
    public double numberOfArticlesDisplayed;

    public CatchingNumbersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private void filterNumber() {
        WebElement total = wrapper.findElement(By.className("subcategories"));
        List<WebElement> subcategory = total.findElements(By.tagName("a"));
        WebElement nadogradnja = subcategory.get(14);
        WebElement numFilter = nadogradnja.findElement(By.tagName("span"));
        numberDisplayedInFilter = Integer.parseInt(numFilter.getText());
        System.out.println("Number of articles in filter:" + numberDisplayedInFilter);

    }
    private void articlesTotal() {
        List<WebElement> articlesOnPage = divArticles.findElements(By.className("col-sm-6"));
        numberOfArticlesDisplayed = articlesOnPage.size();
        System.out.println("Number of articles displayed on the page:" + numberOfArticlesDisplayed);
    }
    public void articlesDisplayed() {
        filterNumber();
        articlesTotal();
    }
}
