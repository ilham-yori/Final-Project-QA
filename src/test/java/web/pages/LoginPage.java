package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By loginMenu = By.id("login2");
    private By usernameField = By.id("loginusername");
    private By passwordField = By.id("loginpassword");
    private By loginButton = By.xpath("//button[text()='Log in']");
    private By welcomeText = By.id("nameofuser");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickLoginMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(loginMenu)).click();
    }

    public void fillUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        driver.findElement(usernameField).sendKeys(username);
    }

    public void fillPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String getWelcomeDashboardText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeText)).getText();
    }
}
