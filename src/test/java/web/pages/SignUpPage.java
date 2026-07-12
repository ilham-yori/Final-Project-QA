package web.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SignUpPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By signUpMenu = By.id("signin2");
    private By usernameField = By.id("sign-username");
    private By passwordField = By.id("sign-password");
    private By registerButton = By.xpath("//button[text()='Sign up']");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickSignUpMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(signUpMenu)).click();
    }

    public void fillUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).clear();
        driver.findElement(usernameField).sendKeys(username);
    }

    public void fillPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public String getAlertTextAndAccept() {
        wait.until(ExpectedConditions.alertIsPresent());
        String text = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return text;
    }
}
