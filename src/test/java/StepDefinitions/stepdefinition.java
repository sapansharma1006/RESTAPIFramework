package StepDefinitions;

import static org.junit.Assert.*;

import Resources.TestDataBuild;
import Resources.Utilities;
//import com.jayway.jsonpath.JsonPath;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import pojo.AddPlace;
import pojo.Location;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class stepdefinition extends Utilities {
    RequestSpecification request;
    ResponseSpecification res;
//    RequestSpecification req;
    Response response;
    TestDataBuild testDataBuild = new TestDataBuild();

    @Given("Add Place Paylod")
    public void add_Place_Paylod() throws IOException {
        // Write code here that turns the phrase above into concrete actions
         request = given().spec(requestSpecification()).body(testDataBuild.addPlacePayload());

    }
    @Given("Add Place Paylod with {string} and {string} and {string}")
    public void add_Place_Paylod_with_and_and(String name, String language, String address) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        request = given().spec(requestSpecification()).body(testDataBuild.addPlaceWithMultipleDataPayload(name,language,address));
    }


    @When("user calls the {string} with post call")
    public void user_calls_the_with_post_call(String string) {
        // Write code here that turns the phrase above into concrete actions
                 res = new ResponseSpecBuilder().
                expectStatusCode(200).expectContentType(ContentType.JSON).build();
         response=  request.
                when().post("/maps/api/place/add/json").
                then().spec(res).extract().response();
//        System.out.println(response.toString());

    }

    @Then("the API call get success message with status code {int}")
    public void the_API_call_get_success_message_with_status_code(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(response.getStatusCode(),200);
    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String key, String value) {
        // Write code here that turns the phrase above into concrete actions
       String resp=  response.getBody().jsonPath().get(key).toString();
        System.out.println(resp);
       assertEquals(resp,value);

    }
}
