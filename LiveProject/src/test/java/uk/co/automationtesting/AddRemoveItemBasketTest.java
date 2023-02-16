package uk.co.automationtesting;

import base.BasePage;
import base.Hooks;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.*;

import java.io.IOException;

@Listeners(resources.Listeners.class)
public class AddRemoveItemBasketTest extends Hooks {

    public AddRemoveItemBasketTest() throws IOException {
        super();
    }

    @Test
    public void endToEndTest() throws IOException, InterruptedException {
        Homepage homepage = new Homepage();
        Thread.sleep(5000);
        // click the toggle button first
        homepage.getToggle().click();
        Thread.sleep(3000);
        // click the test store link
        homepage.getTestStoreLink().click();
        // waiting for test store page to load
        Thread.sleep(3000);
        // click the first item
        ShopHomePage shopHome = new ShopHomePage();
        shopHome.getProdOne().click();

        // select M size
        ProductPage productPage = new ProductPage();
        Select option = new Select(productPage.getSize());
        option.selectByVisibleText("M");
        // increase quantity by 1
        productPage.getQuantityIncrease().click();
        // press add to cart button
        productPage.getAddToCartBtn().click();

        // press continue shopping
        ShopContentPanel shopContentPanel = new ShopContentPanel();
        shopContentPanel.getContShopBtn().click();

        // click homepage link from product page
        productPage.getHomepageLink().click();

        // select product two and add it to cart
        shopHome.getProdTwo().click();

        productPage.getAddToCartBtn().click();

        shopContentPanel.getCheckoutBtn().click();

        // delete the 2nd item
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.getDeleteItemTwo().click();

        waitForElementInvisible(shoppingCart.getDeleteItemTwo(), 10);

        // check the total price
        Assert.assertEquals(shoppingCart.getTotalAmount().getText(), "$45.24");

    }
}
