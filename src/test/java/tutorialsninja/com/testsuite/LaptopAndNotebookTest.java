package tutorialsninja.com.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tutorialsninja.com.pages.LaptopAndNotebookPage;
import tutorialsninja.com.testbase.BaseTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopAndNotebookTest extends BaseTest {
    LaptopAndNotebookPage laptopAndNotebookPage = new LaptopAndNotebookPage();


    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        //1.1 Mouse hover on Laptops & Notebooks Tab and click
        laptopAndNotebookPage.mouseHooverToLaptopsAndNotebooks();
        //1.2 Click on “Show All Laptops & Notebooks”
        laptopAndNotebookPage.clickOnShowAllLaptopsAndNotebooks();
        //1.3 Select Sort By "Price (High > Low)"
        laptopAndNotebookPage.sortByPriceHighToLow();
        //    1.4 Verify the Product price will arrange in High to Low order.
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
        }
        System.out.println(originalProductsPrice);
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        System.out.println(originalProductsPrice);
        //1.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");
        // After filter Price (High > Low) Get all the products price and stored into array list
        products = driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
        }
        System.out.println(afterSortByPrice);
        //1.4 Verify the Product price will arrange in High to Low order.
        Assert.assertEquals("Product not sorted by price High to Low",
                originalProductsPrice, String.valueOf(afterSortByPrice));


    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        laptopAndNotebookPage.mouseHooverToLaptopsAndNotebooks();
        //2.2 Click on “Show All Laptops & Notebooks”
        laptopAndNotebookPage.clickOnShowAllLaptopsAndNotebooks();
        //2.3 Select Sort By "Price (High > Low)"
        laptopAndNotebookPage.sortByPriceHighToLow();
        //2.4 Select Product “MacBook”
        laptopAndNotebookPage.clickOnProductMacbook();
        //2.5 Verify the text “MacBook
        String expectedMacBookText = "MacBook";
        String actualMacBookText = laptopAndNotebookPage.macBookText();
       Assert. assertEquals(expectedMacBookText, actualMacBookText, "Product name wrong");
        //2.6 Click on ‘Add To Cart’ button
        laptopAndNotebookPage.clickOnAddToCartButton();
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!×”
        String expectedSuccessMessage = "Success: You have added MacBook to your shopping cart!\n×";
        String actualSuccessMessage = laptopAndNotebookPage.successMessageText();
        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage, "Product not added to cart");
        //2.8 Click on link “shopping cart” display into success message
        laptopAndNotebookPage.clickOnShoppingCartMessage();
        //2.9 Verify the text "Shopping Cart"
        String expectedShoppingCartText = "Shopping Cart";
        String actualShoppingCartText = laptopAndNotebookPage.shoppingCartText();
        Assert.assertEquals(actualShoppingCartText, expectedShoppingCartText, "Shopping Cart empty");
        //2.10 Verify the Product name "MacBook"
        String expectedProductNameMacBookText = "MacBook";
        String actualProductMacBookText = laptopAndNotebookPage.productNameMacBookText();
        Assert.assertEquals(actualProductMacBookText, expectedProductNameMacBookText, "Product name not found");
        //2.11 Change Quantity "2"
        laptopAndNotebookPage.clearQuantity2FromField();
        laptopAndNotebookPage.enterQuantity2();
        //2.12 Click on “Update” Tab
        laptopAndNotebookPage.clickOnUpdateTab();
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        String expectedSuccessMessage1 = "Success: You have modified your shopping cart!\n×";
        String actualSuccessMessage1 = laptopAndNotebookPage.successMessageText1();
        Assert.assertEquals(actualSuccessMessage1, expectedSuccessMessage1, "Shopping cart not updated");
        //2.14 Verify the Total £737.45 or $1,204.00
        String expectedTotalPrice = "$1,204.00";
        String actualTotalPrice = laptopAndNotebookPage.totalPrice();
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice, "Price not shown");
        laptopAndNotebookPage.clickOnCheckoutButton();
        //2.16 Verify the text “Checkout”
        String expectedCheckoutText = "Checkout";
        String actualCheckoutText = laptopAndNotebookPage.checkoutText();
        Assert.assertEquals(actualCheckoutText, expectedCheckoutText, "Checkout page not found");
        //2.17 Verify the Text “New Customer”
        String expectedNewCustomerText = "New Customer";
        String actualNewCustomerText = laptopAndNotebookPage.newCustomerText();
        Assert.assertEquals(actualCheckoutText, expectedCheckoutText, "New Customer not found");
        //2.18 Click on “Guest Checkout” radio button
        laptopAndNotebookPage.clickOnGuestCheckoutButton();
        //2.19 Click on “Continue” tab
        laptopAndNotebookPage.clickOnContinueTab();
        //2.20 Fill the mandatory fields, enter email into email field
        laptopAndNotebookPage.enterFirstName("Prime");
        laptopAndNotebookPage.enterLastName("Testing");
        laptopAndNotebookPage.enterEmail("prime0088@gmail.com");
        laptopAndNotebookPage.enterPassword("Prime123456");
        laptopAndNotebookPage.enterAddress("101,keats court, Wembley");
        laptopAndNotebookPage.enterCity("London");
        laptopAndNotebookPage.enterPostcode("HA0 3NZ");
        laptopAndNotebookPage.sortByDropDownCountry("United Kingdom");
        laptopAndNotebookPage.sortByDropDownRegion("Greater London");
        laptopAndNotebookPage.clickOnContinueButton();
        laptopAndNotebookPage.enterComments();
        laptopAndNotebookPage.clickOnCheckBox();
        laptopAndNotebookPage.clickOnContinue();
        //2.25 Verify the message Warning: Payment method required!
        String expectedWarningMessageText = "Warning: Payment method required!\n×";
        String actualWarningMessageText = laptopAndNotebookPage.warningMessageText();
        Assert.assertEquals(actualWarningMessageText, expectedWarningMessageText, "Warning message not found");


    }
}
