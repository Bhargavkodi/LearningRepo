package NewThings;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class serviceLearn {
	
	@Test
	public void VerifyPutResponse()
	{
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content-Type","application/json");
		
		JSONObject jsonMain = new JSONObject();
		
		
		jsonMain.put("organizationId","1407053");
		jsonMain.put("recruiterId","1401978");
		jsonMain.put("interviewPositionId","12798");
		jsonMain.put("expiryDays","2");
		jsonMain.put("timeZone","Asia/Calcutta");
		
		JSONArray jarray=new JSONArray();
		JSONObject json = new JSONObject();
		json.put("firstName","Bhargav");
		json.put("lastName","kumar");
		json.put("email","bhargav@yopmail.com");
		json.put("s3HtmlLink","");
		json.put("s3DownloadLink","");
		json.put("isResumeUploaded",false);
		json.put("history",false);
		json.put("oldInterviews",null);
		json.put("profilePic","");
		
		jarray.add(json);
		
		jsonMain.put("candidates", jarray);
		
		
		
		httpRequest.body(jsonMain.toJSONString());
		
		Response response = httpRequest.post("https://panna.mroads.com/panna-services/schedule/schedulePannaInterview");
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);

	}
	
	@Test
	public void VerifyReportResponse()
	{
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content-Type","application/json");
		
		JSONObject jsonMain = new JSONObject();
		
		
		jsonMain.put("uuid","MjE0NTE=");
		
httpRequest.body(jsonMain.toJSONString());
		
		Response response = httpRequest.post("https://panna.mroads.com/panna-portlet/services/reports/getReportByUuid");
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		long resTime = response.getTime();
		System.out.println("Response Time   is =>  " +resTime);

	}
	
	@Test
	public void RegistrationSuccessful()
	{		
		RestAssured.baseURI ="https://panna.mroads.com/panna-services/admin";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender"); // Cast
		requestParams.put("LastName", "Singh");
		requestParams.put("Email",  "ed26bhargav9@yopmail.com");
		requestParams.put("phoneNumber", "9966779940");
		requestParams.put("jobTitle", "HR MANAGER");	
		

		request.body(requestParams.toJSONString());
		Response response = request.post("/updateUser");

		ResponseBody body = response.getBody();
		System.out.println(response.body().asString());

		if(response.statusCode() == 400)
		{
			// Deserialize the Response body into RegistrationFailureResponse
			RegistrationFailureResponse responseBody = body.as(RegistrationFailureResponse.class);

			// Use the RegistrationFailureResponse class instance to Assert the values of 
			// Response.
			Assert.assertEquals("User already exists", responseBody.message);
			Assert.assertEquals("FAULT_USER_ALREADY_EXISTS", responseBody.status);	
			System.out.println("User already exists");
		}
		else if (response.statusCode() == 201)
		{
			// Deserialize the Response body into RegistrationSuccessResponse
			RegistrationSuccessResponse responseBody = body.as(RegistrationSuccessResponse.class);
			// Use the RegistrationSuccessResponse class instance to Assert the values of 
			// Response.
			Assert.assertEquals("OPERATION_SUCCESS", responseBody.SuccessCode);
			Assert.assertEquals("Operation completed successfully", responseBody.Message);	
		}	
	}
	
	
}
