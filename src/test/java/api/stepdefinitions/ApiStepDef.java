package api.stepdefinitions;

import api.pages.ApiPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Assume;

public class ApiStepDef {
    ApiPage apiPage = new ApiPage();

    @Given("base API URL {string}")
    public void baseAPIURL(String url) {
        apiPage.setBaseUrl(url);
    }

    @Given("authentication using app-id token")
    public void authenticationUsingAppIdToken() {
        try {
            apiPage.setAuthToken();
        } catch (RuntimeException ex) {
            System.out.println("[WARN] " + ex.getMessage());
            Assume.assumeTrue("APP_ID not found - skipping API tests", false);
        }
    }

    @When("I send a POST request to create a new user with body:")
    public void iSendAPOSTRequestToCreateANewUserWithBody(String docString) {
        apiPage.createUser(docString);
    }

    @When("I send a GET request to the endpoint to get all of the users list")
    public void iSendAGETRequestToTheEndpointToGetAllOfTheUsersList() {
        apiPage.getAllUsers();
    }

    @When("I send a PUT request for id {string} with body:")
    public void iSendAPUTRequestForIdWithBody(String userId, String docString) {
        apiPage.updateUser(userId, docString);
    }

    @When("I send a delete request for id {string}")
    public void iSendADeleteRequestForId(String userId) {
        apiPage.deleteUser(userId);
    }

    @Then("the API response status code should be {int}")
    public void theAPIResponseStatusCodeShouldBe(int expectedStatus) {
        if (apiPage.lastResponse.getStatusCode() != expectedStatus) {
            System.out.println("====== [DEBUG ERROR API SERVER] ======");
            System.out.println("Actual Status Code: " + apiPage.lastResponse.getStatusCode());
            System.out.println("Error Messages from Server:");
            apiPage.lastResponse.prettyPrint();
            System.out.println("======================================");
        }
        Assert.assertEquals("Wrong API Code!", expectedStatus, apiPage.lastResponse.getStatusCode());
    }

    @Then("the response field {string} should be {string}")
    public void theResponseFieldShouldBe(String key, String expectedValue) {
        String actualValue = apiPage.lastResponse.jsonPath().getString(key);
        Assert.assertEquals("Value Response is Not Equal!", expectedValue, actualValue);
    }

    @When("I send a GET request to the endpoint to get all of the tags")
    public void iSendAGETRequestToTheEndpointToGetAllOfTheTags() {
        apiPage.getAlltags();
    }

    @Then("the response should return the correct deleted user ID")
    public void theResponseShouldReturnTheCorrectDeletedUserID() {
        String actualDeletedId = apiPage.lastResponse.jsonPath().getString("id");
        Assert.assertNotNull("User ID is Empty or Null!", actualDeletedId);
    }
}
