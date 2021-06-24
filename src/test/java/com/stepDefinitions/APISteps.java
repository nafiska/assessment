package com.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.custombdd.pages.APIResponse;

public class APISteps {

	public APIResponse apiResponse;

	@Given("I Form API Request for Employee Details with ID as {int} and {string} as Endpoints For Test Execution")
	public void formGetRequest(int id, String endpoints) throws Throwable {
		apiResponse = new APIResponse();
		apiResponse.URIformation(id, endpoints);
	}
	
	@Then("I Verify Success Code from Server Successfully")
	public void verifyResponseStatusCode() throws Throwable {
		apiResponse = new APIResponse();
		boolean result = apiResponse.apiResponseStatusCodeVerification();
		Assert.assertTrue("StatusCode is not Correct", result);
	}
	
	@Given("I Form API Request to Delete an Employee with ID as {int} and {string} as Endpoints For Test Execution")
	public void formDeleteRequest(int id, String endpoints) throws Throwable {
		apiResponse = new APIResponse();
		apiResponse.URIformation(id, endpoints);
	}
	
	@Then("I Verify Employee Details Removed from Server Successfully")
	public void verifyResponseString() throws Throwable {
		apiResponse = new APIResponse();
		boolean result = apiResponse.apiDeleteOperationVerification();
		Assert.assertTrue("Employee Record is not Removed", result);
	}

}