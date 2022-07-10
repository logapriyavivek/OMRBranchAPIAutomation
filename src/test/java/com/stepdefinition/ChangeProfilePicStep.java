package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.ChangeProfilePic_Output_Pojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import junit.framework.Assert;

/**
 * 
 * @author LOGAPRIYA
 * @Description Used to Maintain ChangeProfilePicStep Method
 * @CreationDate 26/06/2022
 *
 */
public class ChangeProfilePicStep extends BaseClass{
	public static final String commonVariables = null;
	String logtoken;
	Response response;
	String address_id;

	/**
	 * @Description Accessing changeprofilepic by using headers and bearer authorization and multipart/form-data
	 * @CreationDate 26/06/2022
	 */
	@Given("User add headers and bearer authorization and multipart\\/form-data for accessing ChangeProfilePic endpoints")
	public void userAddHeadersAndBearerAuthorizationAndMultipartFormDataForAccessingChangeProfilePicEndpoints() {
		
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type", "multipart/form-data");
		Header h2 = new Header("Authorization", "Bearer " + LoginStep.commonVariables.getLogToken());
		h.add(h1);
		h.add(h2);
		Headers headers = new Headers(h);
		addHeaders(headers);
		multipart();
	    
	}

/**
 * 
 * @param string
 * @Description request for Changeprofilepic
 * @CreationDate 26/06/2022
 */
	@When("User send {string} request for ChangeProfilePic")
	public void userSendRequestForChangeProfilePic(String requestType) {
		response = requestType(requestType, Endpoints.CHANGEPROFILEPIC);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
	    
	}
/**
 * 
 * @param string
 * @Description reponse message matches to verify changeprofilepic
 * @CreationDate 26/06/2022
 */
	@Then("User verify the ChangeProfilePic response message matches with {string}")
	public void userVerifyTheChangeProfilePicResponseMessageMatchesWith(String expected) {
		ChangeProfilePic_Output_Pojo changeprofilepicoutputpojo = response.as(ChangeProfilePic_Output_Pojo.class);
		System.out.println(changeprofilepicoutputpojo.getMessage()); 

		
		Assert.assertEquals("Profile updated Successfully", expected, changeprofilepicoutputpojo.getMessage());
		
	}

}
