package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
/**
 * 
 * @author LOGAPRIYA
 * @Description Used to maintains the reusable methods
 * @CreationDate 20/06/2022
 */
public class BaseClass {
	RequestSpecification reqSpec;
	 Response response;
/**
 * 
 * @param key
 * @param value
 * @Description Used to get the Header
 * @CreationDate 20/06/2022
 */
	public void addHeader(String key, String value) {
		reqSpec = RestAssured.given().header(key, value);
	}
/**
 * 
 * @param headers
 * @Description Used to get the Headers
 * @CreationDate 20/06/2022
 */
	public void addHeaders(Headers headers) {
		reqSpec = RestAssured.given().headers(headers);
	}
/**
 * @Description Used to change the profile pic and their path
 * @CreationDate 20/06/2022
 */
	public void multipart() {
		reqSpec = reqSpec.multiPart("profile_picture",
				new File("C:\\Users\\LOGAPRIYA\\Desktop\\baby-behaviour-and-awareness.jpg"));
	}
/**
 * 
 * @param userName
 * @param password
 * @Description Used to get the Basic Authentication
 * @CreationDate 20/06/2022
 */
	public void basicAuth(String userName, String password) {
		reqSpec = reqSpec.auth().preemptive().basic(userName, password);
	}
/**
 * 
 * @param key
 * @param value
 * @Description Used to get Query Parameter
 * @CreationDate 20/06/2022
 */
	public void queryParam(String key, String value) {
		reqSpec = reqSpec.queryParam(key, value);
	}
/**
 * 
 * @param key
 * @param value
 * @Description Used to get Path Parameter
 * @CreationDate 20/06/2022
 */
	public void pathParam(String key, String value) {
		reqSpec = reqSpec.pathParam(key, value);
	}
/**
 * 
 * @param Key
 * @return String
 * @throws FileNotFoundException
 * @throws IOException
 * @Description Used to get PropertyFileValue
 * @CreationDate 20/06/2022
 */
	public String getPropertyFileValue(String Key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(System.getProperty("user.dir") + "\\config.properties"));
		Object object = properties.get(Key);
		String value = (String) object;
		return value;
	}
/**
 * 
 * @param reqBody
 * @Description AddBody by using String
 * @CreationDate 20/06/2022
 */
	public void addBody(String reqBody) {
		reqSpec = reqSpec.body(reqBody);
	}
/**
 * 
 * @param reqBody
 * @Description AddBody by Using Object
 * @CreationDate 20/06/2022
 */

	public void addBody(Object reqBody) {
		reqSpec = reqSpec.body(reqBody);
	}
/**
 * 
 * @param reqType
 * @param endpoint
 * @return Response
 * @Description Used to get the endpoint for get, post, put & delete
 * @CreationDate 20/06/2022
 */
 
	public Response requestType(String reqType, String endpoint) {
		switch (reqType) {
		case "GET":
			response = reqSpec.log().all().get(endpoint);
			break;
		case "POST":
			response = reqSpec.log().all().post(endpoint);
			break;
		case "PUT":
			response = reqSpec.log().all().put(endpoint);
			break;

		case "DELETE":
			response = reqSpec.log().all().delete(endpoint);
			break;
		default:
			break;
		}
		return response;
	}
/**
 * 
 * @param response
 * @return int
 * @Description Used to get StatusCode
 * @CreationDate 20/06/2022
 */
	public int getStatusCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;
	}
/**
 * 
 * @param response
 * @return ResponseBody
 * @Description Used to get the Response Body
 * @CreationDate 20/06/2022
 */
	public ResponseBody getResponseBody(Response response) {
		ResponseBody responseBody = response.getBody();
		return responseBody;
	}
/**
 * 
 * @param response
 * @return String
 * @Description Used to get ResAsString
 * @CreationDate 20/06/2022
 */
	public String getResAsString(Response response) {
		String asString = getResponseBody(response).asString();
		return asString;
	}
/**
 * 
 * @param response
 * @return String
 * @Description Used to get ResBodyAsPrettyString
 * @CreationDate 20/06/2022
 */
	public String getResBodyAsPrettyString(Response response) {
		String asPrettyString = getResponseBody(response).asPrettyString();
		return asPrettyString;
	}

}
