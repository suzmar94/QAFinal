package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class NadogradnjaTrepavicaPage extends BaseHelper {

    @FindBy(className="col-left-ap")
    WebElement wrapper;

    public NadogradnjaTrepavicaPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private void nadogradnjaTrepavicaOption(){
        wdWait.until(ExpectedConditions.visibilityOf(wrapper));
        WebElement wrapp = wrapper.findElement(By.className("subcategories"));
        List<WebElement> subcategory = wrapp.findElements(By.tagName("a"));
        WebElement nadogradnjaTrepavica = subcategory.get(14);
//        System.out.println("tekst odabrane opcije je:"+nadogradnjaTrepavica.getText());
        js.executeScript("arguments[0].click();", nadogradnjaTrepavica);

    }
    public void nadogradnjaTrepavicaCategory(){
        nadogradnjaTrepavicaOption();
    }
}
