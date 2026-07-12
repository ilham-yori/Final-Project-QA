package api.pages;

import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiPage {
    private String baseUrl;
    private String token;
    public Response lastResponse;

    public void setBaseUrl(String url) {
        this.baseUrl = url;
        RestAssured.baseURI = this.baseUrl;
    }

    public void setAuthToken() {
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing()
                .load();

        String extractedToken = dotenv.get("APP_ID");
        if (extractedToken == null || extractedToken.isEmpty()) {
            extractedToken = System.getenv("APP_ID");
        }

        if (extractedToken == null || extractedToken.isEmpty()) {
            throw new RuntimeException("ERROR: Variable APP_ID is not found in the .env or Environment Variable System");

        }

        this.token = extractedToken.trim();
    }

    private RequestSpecification getFreshRequest(){
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .header("app-id", this.token);
    }

    public void createUser(String jsonBody) {

        this.lastResponse = getFreshRequest().body(jsonBody).post("user/create");
    }

    public void getAllUsers() {

        this.lastResponse = getFreshRequest().get("user");
    }

    public void updateUser(String userId, String jsonBody) {
        this.lastResponse = getFreshRequest().body(jsonBody).put("user/" + userId);
    }

    public void getAlltags(){
        this.lastResponse = getFreshRequest().get("tag");
    }

    public void deleteUser(String userId) {

        this.lastResponse = getFreshRequest().delete("user/" + userId);
    }
}
