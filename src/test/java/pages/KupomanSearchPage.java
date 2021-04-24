package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KupomanSearchPage extends BaseHelper {

    @FindBy(className="sub-menu__search_wrapper")
    WebElement subMenu;

    public KupomanSearchPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private void navigateToPage(){
        driver.get("https://www.kupoman.rs/");
    }
    private void insertTerm(String term){
        WebElement searchForm = subMenu.findElement(By.tagName("form"));
        WebElement searching = searchForm.findElement(By.className("input"));
        searching.click();
        searching.sendKeys(term);
    }
    private void buttonSubmit(){
        WebElement searchForm = subMenu.findElement(By.tagName("form"));
        WebElement searching = searchForm.findElement(By.tagName("button"));
        searching.click();
    }
    public void searchingTerm(String term){
        navigateToPage();
        insertTerm(term);
        buttonSubmit();
    }
}
