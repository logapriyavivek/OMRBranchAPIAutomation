package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.CommonVariables;
import com.pojo.Login_Output_Pojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import junit.framework.Assert;

/**
 * 
 * @author LOGAPRIYA
 * @Description Used to Maintain LoginStep Methods
 * @CreationDate 26/06/2022
 *
 */
public class LoginStep extends BaseClass {
	String logtoken;
    Response response;
    
	public static CommonVariables commonVariables= new CommonVariables();

	/**
	 * @Description Used to add Header
	 * @CreationDate 26/06/2022
	 */
	@Given("User add header")
	public void userAddHeader() {
		addHeader("Content-Type", "application/json");
	}
/**
 * 
 * @throws FileNotFoundException
 * @throws IOException
 * @Description Used to login by adding basic authentication
 * @CreationDate 26/06/2022
 */
	@Given("User add basic authentication for login")
	public void userAddBasicAuthenticationForLogin() throws FileNotFoundException, IOException {
		basicAuth(getPropertyFileValue("userName"), getPropertyFileValue("password"));
	}

	/**
	 * 
	 * @param requestType
	 * @Description Used to login by using Endpoint
	 * @CreationDate 26/06/2022
	 */
	@When("User Send {string} request for login endpoint")
	public void userSendRequestForLoginEndpoint(String requestType) {
		 response = requestType(requestType, Endpoints.LOGIN);
		 int statusCode = getStatusCode(response);
		 commonVariables.setStatusCode(statusCode);
	}

	/**
	 * 
	 * @param expValue
	 * @Description Used to save the logtoken
	 * @CreationDate 26/06/2022
	 */
	@Then("User verify the login response body firstname present as {string} and get the logtoken saved")
	public void userVerifyTheLoginResponseBodyFirstnamePresentAsAndGetTheLogtokenSaved(String firstName) {
		Login_Output_Pojo loginoutputpojo = response.as(Login_Output_Pojo.class);
		String first_name = loginoutputpojo.getData().getFirst_name();
		System.out.println(firstName);
		
		Assert.assertEquals("Verify firstName Logapriya", first_name, firstName);
		logtoken = loginoutputpojo.getData().getLogtoken();
		commonVariables.setLogToken(logtoken);
		System.out.println(logtoken);
	}
}