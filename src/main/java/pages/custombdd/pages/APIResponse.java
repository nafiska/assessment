package pages.custombdd.pages;

import org.apache.log4j.Logger;

import com.cucumber.helper.ParameterService;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIResponse {
	
	private static Logger Log = Logger.getLogger(APIResponse.class);
	
	String uri;
	
	public void URIformation(int id, String endpoints) { 
		String empID = Integer.toString(id);
		
		switch(endpoints) {
		
			case "employee":
				uri = "http://dummy.restapiexample.com/api/v1/employee/"+empID;
				ParameterService.setParameter("URI", uri);
				break;
			case "delete":	
				uri = "http://dummy.restapiexample.com/api/v1/delete/"+empID;
				ParameterService.setParameter("URI", uri);
				break;
			default:
				Log.info("Invalid Endpoints. Please Enter Valid one.");
				break;
		}
	}

	public boolean apiResponseStatusCodeVerification() {
		String uri = ParameterService.getParameter("URI");
		RestAssured.baseURI = uri;
		RequestSpecification request = RestAssured.given();
		Response response = request.get(); 
		int responseStatusCode = response.getStatusCode();
		Log.info("Response Status Code :  " + responseStatusCode);
		if(responseStatusCode == 200)
			return true;
		else
			return false;
	}
	
	public boolean apiDeleteOperationVerification() {
		String uri = ParameterService.getParameter("URI");
		RestAssured.baseURI = uri;
		RequestSpecification request = RestAssured.given();
		Response response = request.delete(); 
		String responseString = response.asString();
		Log.info("Response String :  " + responseString);
		if(responseString.contains("Successfully! Record has been deleted"))
			return true;
		else
			return false;
	}
	
	
}
