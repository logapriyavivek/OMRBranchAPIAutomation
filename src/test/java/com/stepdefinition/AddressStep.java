package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.payload.Payload;
import com.pojo.AddAddress_Input_pojo;
import com.pojo.AddAddress_Output_Pojo;
import com.pojo.DeleteAddress_Input_Pojo;
import com.pojo.DeleteAddress_Output_Pojo;
import com.pojo.GetAddress_Output_Pojo;
import com.pojo.UpdateAddress_Input_Pojo;
import com.pojo.UpdateAddress_Output_Pojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

/**
 * 
 * @author LOGAPRIYA
 *@Description Used to Maintain AddressStep Method
 * @CreationDate 26/06/2022
 */
public class AddressStep extends BaseClass{
	String logtoken;
	Response response;
	static String address_id;
	
	/**
	 * @Description Used for accessing address endpoints
	 * @CreationDate 26/06/2022
	 */
	@Given("User add headers and bearer authorization for accessing address endpoints")
	public void userAddHeadersAndBearerAuthorizationForAccessingAddressEndpoints() {
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + LoginStep.commonVariables.getLogToken());
		h.add(h1);
		h.add(h2);
		Headers headers = new Headers(h);
		addHeaders(headers);
	    }
	
	/**
	 * 
	 * @param first_name
	 * @param last_name
	 * @param mobile
	 * @param apartment
	 * @param state
	 * @param city
	 * @param country
	 * @param zipcode
	 * @param address
	 * @param address_type
	 * @Description Add request body to create Address
	 * @CreationDate 26/06/2022
	 */
	@When("User add request body for Add new Address {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} and {string}")
	public void userAddRequestBodyForAddNewAddressAnd(String first_name, String last_name, String mobile, String apartment, String state, String city, String country, String zipcode, String address, String address_type) {
		AddAddress_Input_pojo createAddress = Payload.createAddress("Logapriya", "Vivekanandhan","9952073232", "apartment", 33, 3378, 101, "202020", "kodambakkam", "home");
		addBody(createAddress);
	}
	/**
	 * 
	 * @param string
	 * @Description Used to create Address by sending request
	 * @CreationDate 26/06/2022
	 */

	@When("User send {string} request for add new address")
	public void userSendRequestForAddNewAddress(String addRequest) {
	  response = requestType(addRequest, Endpoints.ADDADDRESS);
	}

	/**
	 * 
	 * @param string
	 * @Description response message matches to verify create address
	 * @CreationDate 26/06/2022
	 */
	@Then("User verify the Create address response message matches {string}")
	public void userVerifyTheCreateAddressResponseMessageMatches(String expected) {
		AddAddress_Output_Pojo addaddressoutputpojo = response.as(AddAddress_Output_Pojo.class);
		String message = addaddressoutputpojo.getMessage();
		System.out.println(expected);
		System.out.println(message);
		Assert.assertEquals("Address added successfully", expected, addaddressoutputpojo.getMessage());
		LoginStep.commonVariables.setAddress_id(String.valueOf(addaddressoutputpojo.getAddress_id()));
	}
/**
 * 
 * @param string
 * @param string2
 * @param string3
 * @param string4
 * @param string5
 * @param string6
 * @param string7
 * @param string8
 * @param string9
 * @param string10
 * @Description Update existing address for request body
 * @CreationDate 26/06/2022
 */
	@When("User add request body to update existing address {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} and {string}")
	public void userAddRequestBodyToUpdateExistingAddressAnd(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10) {
		
		UpdateAddress_Input_Pojo updateAddress = Payload.updateAddress(address_id, "Logapriya",
				"Vivekanandhan", "9952073232", "apartment", 33, 3378, 101, "202020", "kodambakkam", "home");
		addBody(updateAddress);

		
	}
/**
 * 
 * @param string
 * @Description Used to update existing address by sending request
 * @CreationDate 26/06/2022
 */
	@When("User send {string} request to update the exsiting address")
	public void userSendRequestToUpdateTheExsitingAddress(String updateRequest) {
		response = requestType(updateRequest, Endpoints.UPDATEADDRESS);
	    
	}
/**
 * 
 * @param string
 * @Description response message matches to verify the update address
 * @CreationDate 26/06/2022
 */
	@Then("User verify the Update address response message matches {string}")
	public void userVerifyTheUpdateAddressResponseMessageMatches(String expected) {
		UpdateAddress_Output_Pojo updateAddressoutputpojo = response.as(UpdateAddress_Output_Pojo.class);
		System.out.println(updateAddressoutputpojo.getMessage()); 
		Assert.assertEquals("Address updated successfully", expected, updateAddressoutputpojo.getMessage());
		
	}
/**
 * 
 * @param string
 * @Description Used to get the existing address by sending request
 * @CreationDate 26/06/2022
 */
	@When("User send {string} request to get the existing address")
	public void userSendRequestToGetTheExistingAddress(String getRequest) {
		
		response = requestType(getRequest, Endpoints.GETADDRESS);
	  
	}
/**
 * 
 * @param string
 * @Description response message matches to verify the get address
 * @CreationDate 26/06/2022
 */
	@Then("User verify the Get address response message matches {string}")
	public void userVerifyTheGetAddressResponseMessageMatches(String expected) {
		GetAddress_Output_Pojo getaddressoutputpojo = response.as(GetAddress_Output_Pojo.class);
		System.out.println(getaddressoutputpojo.getMessage());
		Assert.assertEquals("OK", expected, getaddressoutputpojo.getMessage());
	}

	/**
	 * 
	 * @param string
	 * @Description Used to delete the address by sending request
	 * @CreationDate 26/06/2022
	 */
	@When("User send {string} request to delete the address")
	public void userSendRequestToDeleteTheAddress(String Delete) {
		
		DeleteAddress_Input_Pojo deleteAddress = Payload.deleteAddress(LoginStep.commonVariables.getAddress_id());
		addBody(deleteAddress);
		response = requestType("DELETE", Endpoints.DELETEADDRESS);
	    
	}

	
	/**
	 * 
	 * @param string
	 * @Description Response message matches to verify the delete address
	 * @CreationDate 26/06/2022
	 */
	@Then("User verify the Delete address response message matches {string}")
	public void userVerifyTheDeleteAddressResponseMessageMatches(String expected) {
		DeleteAddress_Output_Pojo deleteaddressoutputpojo = response.as(DeleteAddress_Output_Pojo.class);
		System.out.println(deleteaddressoutputpojo.getMessage());
		Assert.assertEquals("Address deleted successfully", expected, deleteaddressoutputpojo.getMessage());
		}
		
}