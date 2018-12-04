package NewThings;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class restLearning {
	
	@Test
	public void CheckService()
	{   
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "https://play-acyuta.mroads.com/acyuta-services/jobs";
		
		RequestSpecification httpRequest = RestAssured.given();
		 
		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.
		Response response = httpRequest.request(Method.GET, "/loadMailTemplates");
 
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
	}
	
	@Test
	public void VerifyCityInJsonResponse()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Hyderabad");

		// First get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();

		// Then simply query the JsonPath object to get a String value of the node
		// specified by JsonPath: City (Note: You should not put $. in the Java code)
		String city = jsonPathEvaluator.get("City");

		// Let us print the city variable to see what we got
		System.out.println("City received from Response " + city);

		// Validate the response
		Assert.assertEquals(city, "Hyderabad", "Correct city name received in the Response");

	}
	
	
	@Test
	public void VerifyJsonResponse()
	{
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/posts");

		// First get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();


		List<String> allBooks = jsonPathEvaluator.getList("books.title");
		 
		// Iterate over the list and print individual book item
		for(String book : allBooks)
		{
			System.out.println("Book: " + book);
		}
	}

	
	

}
