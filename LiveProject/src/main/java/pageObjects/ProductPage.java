package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {

    public WebDriver driver;
    By size = By.cssSelector("[data-product-attribute='1']");
    By quantityIncrease = By.cssSelector(".touchspin-up");
    By quantityDecrease = By.cssSelector(".touchspin-down");
    By addToCartBtn = By.cssSelector("[data-button-action]");

    By homepageLink = By.xpath("//*[@id=\"wrapper\"]/div/nav/ol/li[1]/a/span");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSize() {
        return driver.findElement(size);
    }

    public WebElement getQuantityIncrease(){
        return driver.findElement(quantityIncrease);
    }

    public WebElement getQuantityDecrease(){
        return driver.findElement(quantityDecrease);
    }

    public WebElement getAddToCartBtn(){
        return driver.findElement(addToCartBtn);
    }

    public WebElement getHomepageLink(){
        return driver.findElement(homepageLink);
    }
}
