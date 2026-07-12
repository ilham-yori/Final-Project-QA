package web.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import web.pages.LoginPage;
import common.hooks.WebHook;


public class LoginStepDef {
    private LoginPage loginPage;
    private String savedUsername;

    public LoginStepDef() {
        this.loginPage = new LoginPage(WebHook.getDriver());
    }

    @Given("User on the homepage")
    public void bukaHalamanUtama() {
        WebHook.getDriver().get("https://www.demoblaze.com/");
    }

    @When("User click on menu \"Log in\"")
    public void klikMenuLogin() {
        loginPage.clickLoginMenu();
    }

    @And("User fill out the correct username {string}")
    public void isiUsernameLogin(String username) {
        this.savedUsername = username;
        loginPage.fillUsername(username);
    }

    @And("User fill out the correct password {string}")
    public void isiPasswordLogin(String password) {
        loginPage.fillPassword(password);
    }

    @And("User click on login button")
    public void konfirmasiMasuk() {
        loginPage.clickLoginButton();
    }

    @Then("Page shows the user name")
    public void validasiSuksesLogin() {
        String actualWelcomeText = loginPage.getWelcomeDashboardText();
        Assertions.assertTrue(actualWelcomeText.contains(savedUsername));
    }
}
