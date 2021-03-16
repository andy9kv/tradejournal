package hellocucumber;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.junit.Assert.assertEquals;

public class StepDefinitions {

    private String DOMAIN_PATH;
    private Response response;
    private String JSONbody;
    private Map<String, String> testEntries = new HashMap<String, String>() {{
        put("tradeId", "3");
        put("ticker", "AAPL");
        put("date", "2012-08-12");
        put("entryPrice", "125.12");
        put("exitPrice", "2.12");
        put("comments", "What a terrible trade");
    }};

    @Before
    public void setup_tests() {
        DOMAIN_PATH = "http://localhost:8080";
    }

    @Given("there are {int} trades logged")
    public void there_are_trades_logged(Integer int1) {

        JSONObject json = new JSONObject(testEntries);
        this.JSONbody = json.toString();

        given().header("Content-Type", "application/JSON").body(this.JSONbody).when().post(DOMAIN_PATH + "/trade/post");
    }

    @When("I request for trades to the get {string}")
    public void i_request_for_trades_to_the_get_endpoint_trade_journal(String endpoint) {

        this.response = when().get(DOMAIN_PATH + endpoint);

    }
    @Then("I should see all the trades")
    public void i_should_see_all_the_trades() {

        this.response.then().statusCode(200);
        final JsonPath jsonPath = this.response.jsonPath();
        final String tradeId = jsonPath.getString("tradeId[0]");
        final String date = jsonPath.getString("date[0]");
        final String ticker = jsonPath.getString("ticker[0]");
        final String entryPrice = jsonPath.getString("entryPrice[0]");
        final String exitPrice = jsonPath.getString("exitPrice[0]");
        final String comments = jsonPath.getString("comments[0]");

        assertEquals(testEntries.get("tradeId"), tradeId);
        assertEquals(testEntries.get("date"), date.substring(0, 10));
        assertEquals(testEntries.get("ticker"), ticker);
        assertEquals(testEntries.get("entryPrice"), entryPrice);
        assertEquals(testEntries.get("exitPrice"), exitPrice);
        assertEquals(testEntries.get("comments"), comments);
    }

}
