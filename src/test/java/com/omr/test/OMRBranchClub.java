package com.omr.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.payload.Payload;
import com.pojo.AddAddress_Output_Pojo;
import com.pojo.ChangeProfilePic_Output_Pojo;
import com.pojo.DeleteAddress_Output_Pojo;
import com.pojo.GetAddress_Output_Pojo;
import com.pojo.Login_Output_Pojo;
import com.pojo.UpdateAddress_Output_Pojo;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
/**
 * 
 * @author LOGAPRIYA
 * @Description  To Automate the Post, Update, Get and Delete through API
 * @CreationDate 26/06/2022
 * 
 *
 */
public class OMRBranchClub extends BaseClass {
	String logtoken;
	String address_id;
/**
 * 
 * @throws FileNotFoundException
 * @throws IOException
 * @Description Used to perform Login
 * @CreationDate 26/06/2022
 */
	@Test(priority = 1)
	public void login() throws FileNotFoundException, IOException {
		addHeader("Content-Type", "application/json");
		basicAuth(getPropertyFileValue("userName"), getPropertyFileValue("password"));
		Response response = requestType("POST", Endpoints.LOGIN);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "verify StatusCode");

		Login_Output_Pojo loginoutputpojo = response.as(Login_Output_Pojo.class);
		String first_name = loginoutputpojo.getData().getFirst_name();
		System.out.println(first_name);
		Assert.assertEquals(first_name, "Logapriya", "verify firstName");

		logtoken = loginoutputpojo.getData().getLogtoken();

	}
/**
 * @Description Used to Create the address
 * @CreationDate 26/06/2022
 */
	@Test(priority = 2)
	private void addAddress() {
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		h.add(h1);
		h.add(h2);
		Headers headers = new Headers(h);
		addHeaders(headers);
		
		Payload.createAddress("Logapriya", "Vivekanandhan","9952073232", "apartment", 33, 3378, 101, "202020", "kodambakkam", "home");
		
		Response response = requestType("POST", Endpoints.ADDADDRESS);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "verify StatusCode");

		AddAddress_Output_Pojo addaddressoutputpojo = response.as(AddAddress_Output_Pojo.class);
		String message = addaddressoutputpojo.getMessage();
		System.out.println(message);
		int id = addaddressoutputpojo.getAddress_id();
		address_id = String.valueOf(id);
		System.out.println(address_id);

		Assert.assertEquals(message, "Address added successfully", "verify Address added successfully");
	}
/**
 * @Description Used to update the Address
 * @CreationDate 26/06/2022
 */
	@Test(priority = 3)
	public void updateAddress() {
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		h.add(h1);
		h.add(h2);
		Headers headers = new Headers(h);
		addHeaders(headers);
		
		
	    Payload.updateAddress(address_id, "Logapriya", "Vivekanandhan", "9952073232", "apartment", 33, 3378, 101, "202020", "kodambakkam", "home");

		Response response = requestType("PUT", Endpoints.UPDATEADDRESS);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		System.out.println(getResBodyAsPrettyString(response));
		Assert.assertEquals(statusCode, 200, "verify StatusCode");

		UpdateAddress_Output_Pojo updateAddressoutputpojo = response.as(UpdateAddress_Output_Pojo.class);
		String message = updateAddressoutputpojo.getMessage();
		System.out.println(message);
		Assert.assertEquals(message, "Address updated successfully", "verify Address updated successfully");
	}
/**
 * @Description Used to get the Address
 * @CreationDate 26/06/2022
 */
	@Test(priority = 4)
	private void getAddress() {
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		h.add(h1);
		h.add(h2);
		Headers headers = new Headers(h);
		addHeaders(headers);

		Response response = requestType("GET", Endpoints.GETADDRESS);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		System.out.println(getResBodyAsPrettyString(response));
		Assert.assertEquals(statusCode, 200, "verify StatusCode");

		GetAddress_Output_Pojo getaddressoutputpojo = response.as(GetAddress_Output_Pojo.class);
		String message = getaddressoutputpojo.getMessage();
		Assert.assertEquals(message, "OK", "verify OK");

	}
/**
 * @Description Used to delete the Address
 * @CreationDate 26/06/2022
 */
	@Test(priority = 5)
	private void deleteAddress() {
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		h.add(h1);
		h.add(h2);
		Headers headers = new Headers(h);
		addHeaders(headers);
	
		Payload.deleteAddress(address_id);
		Response response = requestType("DELETE", Endpoints.DELETEADDRESS);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "verify StatusCode");

		DeleteAddress_Output_Pojo deleteaddressoutputpojo = response.as(DeleteAddress_Output_Pojo.class);
		String message = deleteaddressoutputpojo.getMessage();
		System.out.println(message);
		Assert.assertEquals(message, "Address deleted successfully", "verify Address deleted successfully");

	}
/**
 * @Description Used for Change the profile pic
 * @CreationDate 26/06/2022
 */
	@Test(priority = 6)
	public void ChangeProfilePic() {
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type", "multipart/form-data");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		h.add(h1);
		h.add(h2);
		Headers headers = new Headers(h);
		addHeaders(headers);
		multipart();
		Response response = requestType("POST", Endpoints.CHANGEPROFILEPIC);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "verify StatusCode");

		ChangeProfilePic_Output_Pojo changeprofilepicoutputpojo = response.as(ChangeProfilePic_Output_Pojo.class);
		String message = changeprofilepicoutputpojo.getMessage();
		Assert.assertEquals(message, "Profile updated Successfully", "verify Profile updated Successfully");

	}
}
