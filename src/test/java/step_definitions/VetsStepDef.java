package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ResponseBody;

import org.junit.Assert;
import support.MyConfig;
import support.SupportFunctions;

public class VetsStepDef {

    private static ResponseBody body;
    private static String ownerInfo = " ";
    @When("user wants to create a vet with {string}")
    public void user_wants_to_create_a_vet(String jsondata) throws Throwable {
    	body = SupportFunctions.post(MyConfig.Endpoint + "api/vets",jsondata);
        System.out.println(body.asString() + SupportFunctions.getResponseCode());
        Assert.assertEquals("Response Code",201,SupportFunctions.getResponseCode());
        ownerInfo =body.asString().split("specialties")[0];
		System.out.println(ownerInfo);
    }


    @Then("validate the creation of vet")
    public void validate_the_creation_of_vet() throws Throwable {
    	body = SupportFunctions.get(MyConfig.Endpoint + "api/vets");
    	Assert.assertEquals("Response Code",200,SupportFunctions.getResponseCode());
        Assert.assertTrue(body.asString().contains(ownerInfo));
    }

}
