package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By laptopCategory = By.linkText("Laptops");
    private By macbookProduct = By.linkText("MacBook air");
    private By addToCartBtn = By.linkText("Add to cart");
    private By cartTabMenu = By.id("cartur");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectLaptopCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(laptopCategory)).click();
    }

    public void selectMacbookProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(macbookProduct)).click();
    }

    public void clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
    }

    public String getAlertMessageAndAccept() {
        wait.until(ExpectedConditions.alertIsPresent());
        String msg = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return msg;
    }

    public void clickCartMenuLink() {
        wait.until(ExpectedConditions.elementToBeClickable(cartTabMenu)).click();
    }
}
