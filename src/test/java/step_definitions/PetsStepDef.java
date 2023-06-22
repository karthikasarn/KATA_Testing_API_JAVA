package step_definitions;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ResponseBody;
import support.MyConfig;
import support.SupportFunctions;

public class PetsStepDef {

    private static ResponseBody body;
    private static String ownerID = " ";

    @When("user wants to add a new pet with {string}")
    public void user_wants_to_add_new_pet(String jsonFile) throws Throwable {
    	String jsonData = "";
    	jsonData = SupportFunctions.readJsonFromFile(jsonFile);
		System.out.println("Read data: " + jsonData);
		body = SupportFunctions.post(MyConfig.Endpoint + "api/pets",jsonData);
		System.out.println(body.asString() + SupportFunctions.getResponseCode());
		ownerID =body.asString().split("birthDate")[0];
		System.out.println(ownerID);
		Assert.assertEquals("Response Code",201,SupportFunctions.getResponseCode());
    }


    @Then("validate the {int} and pet details added")
    public void validate_the_pet_details_added(int statusCode) throws Throwable {
    	body = SupportFunctions.get(MyConfig.Endpoint + "api/pets");
    	System.out.println(body.asString() + SupportFunctions.getResponseCode());
    	Assert.assertEquals("Response Code",statusCode,SupportFunctions.getResponseCode());
        Assert.assertTrue(body.asString().contains(ownerID));
    }

}
