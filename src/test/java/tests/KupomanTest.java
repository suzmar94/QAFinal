package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.CatchingNumbersPage;
import pages.KupomanBeautyAndWellnessPage;
import pages.KupomanSearchPage;
import pages.NadogradnjaTrepavicaPage;

public class KupomanTest extends BaseTest{
    @Test
    public void KupomanSearchTest() throws InterruptedException {

        KupomanSearchPage termSearch = new KupomanSearchPage(driver);
        termSearch.searchingTerm("depilacija");

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("page-content")));
        WebElement searchResults = driver.findElement(By.className("page-content"));
        //class="page-content container "
        Assert.assertTrue("Search term is not found",
                searchResults.getText().contains("depilacija"));

        //due to visual confirmation
        Thread.sleep(4000);
    }

    @Test
    public void KupomanBeautyAndWellnessTest() throws InterruptedException {

        KupomanBeautyAndWellnessPage articlesDisplayed = new KupomanBeautyAndWellnessPage(driver);
        articlesDisplayed.clickOnlepotaIWellness();

        NadogradnjaTrepavicaPage categorySelection = new NadogradnjaTrepavicaPage(driver);
        categorySelection.nadogradnjaTrepavicaCategory();

        CatchingNumbersPage articleNumber = new CatchingNumbersPage(driver);
        articleNumber.articlesDisplayed();

        //due to visual confirmation
        Thread.sleep(4000);
    }
}
