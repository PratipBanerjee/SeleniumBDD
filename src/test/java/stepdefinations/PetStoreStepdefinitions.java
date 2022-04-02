package stepdefinations;

import framework.dependencyinjection.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import scenariocontext.ScenarioContext;
import java.util.List;
import org.testng.Assert;


public class PetStoreStepdefinitions {

    private ScenarioContext scenarioContext;

    public PetStoreStepdefinitions(TestContext testContext, ScenarioContext scenarioContext)
    {
        this.scenarioContext=scenarioContext;
    }

    @Given("Customer will do this for number of pets \"(.*)\"$")
    public void CustomerWillDoThisForNumberOfPets(String testData)
    {

    }
    
    
    @Given("Add a pet to Pet Store with Name as \"(.*)\"$")
    public void LoginAsUser(String testData)
    {
        try
        {
            RequestSpecification request = RestAssured.given()
                                                        .header("Content-type", "application/json")
                                                        .body(scenarioContext.getAddPetRequestBody(testData));

            scenarioContext.response = request.post("/v2/pet");
            JsonPath jsonPath = scenarioContext.response.jsonPath();
            scenarioContext.petID = jsonPath.getString("id");
            Assert.assertEquals(scenarioContext.response.statusCode(), 200);
            Assert.assertEquals(jsonPath.getString("name"), testData);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @When("Get the count of total available pets")
    public void GetCountAvailablePets()
    {
        try
        {
            RequestSpecification request = RestAssured.given()
                                                        .header("Content-type", "application/json");

            scenarioContext.response = request.get("/v2/pet/findByStatus?status=available");
            JsonPath jsonPath = scenarioContext.response.jsonPath();

            List availableCount = jsonPath.getList("id");
            scenarioContext.availablePetCount = availableCount.size();
            Assert.assertEquals(scenarioContext.response.statusCode(), 200);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @When("Delete the Pet recently added")
    public void ValidatePresenceOfLoginMessage()
    {
        try
        {
            RequestSpecification request = RestAssured.given()
                                                        .pathParam("petId", scenarioContext.petID);

            scenarioContext.response = request.delete("/v2/pet/{petId}");
            JsonPath jsonPath = scenarioContext.response.jsonPath();

            Assert.assertEquals(scenarioContext.response.statusCode(), 200);
            Assert.assertEquals(jsonPath.getString("message"), scenarioContext.petID);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the Pet got deleted")
    public void ValidateThePetGotDeleted()
    {
        try
        {
            RequestSpecification request = RestAssured.given()
                                                        .pathParam("petId", scenarioContext.petID);

            scenarioContext.response = request.get("/v2/pet/{petId}");
            JsonPath jsonPath = scenarioContext.response.jsonPath();

            Assert.assertEquals(scenarioContext.response.statusCode(), 404);
            Assert.assertEquals(jsonPath.getString("message"), "Pet not found");
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Validate the total count of available pets is reduced")
    public void ValidateTheTotalCountOfAvailablePetsIsReduced()
    {
        try
        {
            RequestSpecification request = RestAssured.given()
                                                        .header("Content-type", "application/json");

            scenarioContext.response = request.get("/v2/pet/findByStatus?status=available");
            JsonPath jsonPath = scenarioContext.response.jsonPath();

            List availableCount = jsonPath.getList("id");

            int newCountAvailablePets = availableCount.size();
            int oldAvailableCount = scenarioContext.availablePetCount - 1;
            Assert.assertEquals(newCountAvailablePets, oldAvailableCount);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Then("Order a Pet")
    public void OrderPet()
    {
        try
        {
            RequestSpecification request = RestAssured.given()
                                                        .header("Content-type", "application/json")
                                                        .body(scenarioContext.getOrderPetRequestBody(scenarioContext.petID, scenarioContext.getGMTDateTime()));

            scenarioContext.response = request.post("/v2/store/order");
            JsonPath jsonPath = scenarioContext.response.jsonPath();
            Assert.assertEquals(scenarioContext.response.statusCode(), 200);
            Assert.assertEquals(jsonPath.getString("petId"), scenarioContext.petID);
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }




}
