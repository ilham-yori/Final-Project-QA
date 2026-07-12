package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By placeOrderButton = By.xpath("//button[text()='Place Order']");
    private By inputName = By.id("name");
    private By inputCountry = By.id("country");
    private By inputCity = By.id("city");
    private By inputCard = By.id("card");
    private By inputMonth = By.id("month");
    private By inputYear = By.id("year");
    private By purchaseButton = By.xpath("//button[text()='Purchase']");
    private By orderSuccessHeader = By.xpath("//h2[text()='Thank you for your purchase!']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickPlaceOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton)).click();
    }

    public void fillCheckoutDetails(String name, String country, String city, String card, String month, String year) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputName)).sendKeys(name);
        driver.findElement(inputCountry).sendKeys(country);
        driver.findElement(inputCity).sendKeys(city);
        driver.findElement(inputCard).sendKeys(card);
        driver.findElement(inputMonth).sendKeys(month);
        driver.findElement(inputYear).sendKeys(year);
    }

    public void clickPurchase() {
        driver.findElement(purchaseButton).click();
    }

    public String getConfirmationText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(orderSuccessHeader)).getText();
    }
}
