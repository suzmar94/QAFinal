package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.*;

public class KupomanTest extends BaseTest {
    @Test
    public void KupomanSearchTermTest() throws InterruptedException {

        KupomanSearchTermPage termSearch = new KupomanSearchTermPage(driver);
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
    public void KupomanLepotaIWellnessTest() throws InterruptedException {

        KupomanMainOnePage articlesDisplayed = new KupomanMainOnePage(driver);
        articlesDisplayed.clickOnlepotaIWellness();

        LepotaIWellnessPage categorySelection = new LepotaIWellnessPage(driver);
        categorySelection.nadogradnjaTrepavicaCategory();

        CatchingNumbersPage articleNumber = new CatchingNumbersPage(driver);
        articleNumber.articlesDisplayed();

        double filteredNumber = articleNumber.numberDisplayedInFilter;
        double articlesNumber = articleNumber.numberOfArticlesDisplayed;

        Assert.assertEquals(filteredNumber, articlesNumber, 0.01);

        //due to visual confirmation
        Thread.sleep(4000);
    }

    @Test
    public void KupomanHranaIPiceTest() throws InterruptedException {

        KupomanMainTwoPage hranaIPice = new KupomanMainTwoPage(driver);
        hranaIPice.clickOnHranaIPice();

        HranaIPicePage categorySelection = new HranaIPicePage(driver);
        categorySelection.konobaAkustikCategory();

        FirstMealPage firstOffer = new FirstMealPage(driver);
        firstOffer.firstMealClick();

        SelectMealOfferPage selectMeal = new SelectMealOfferPage(driver);
        selectMeal.selectMealOffer();

        AddToCartPage cartAddition = new AddToCartPage(driver);
        cartAddition.addToCart();

        cartAddition.oneUnitPrice = cartAddition.oneUnitPrice.replace(",00", "");

        double mealPrice = Double.parseDouble(cartAddition.oneUnitPrice);
        double totalPrice = Double.parseDouble(cartAddition.chosenUnitsPrice);
        double quantity = 2;

        Assert.assertEquals(totalPrice, mealPrice * quantity, 001);

        //due to visual confirmation
        Thread.sleep(4000);
    }
}
