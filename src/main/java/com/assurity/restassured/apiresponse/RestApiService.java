package com.assurity.restassured.apiresponse;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * common class for rest-api methods like GET,POST,PUT,DEL
 * 
 * @author Reddi
 *
 */
public class RestApiService {

	RequestSpecification requestSpec = given();
	public Response response = null;

	/*
	 * * Method for Post Request
	 */
	public Response post_request(String contentType, String jsonObject, String url) {
		if (contentType.equalsIgnoreCase("JSON")) {
			response = requestSpec.contentType(contentType).body(jsonObject).when().post(url);
		}
		return response;
	}

	/*
	 * * Method for Get Request
	 */
	public Response get_request(String url) {
		response = requestSpec.when().get(url).then().extract().response();
		return response;
	}

	/*
	 * * Method for Put Request
	 */
	public Response put_request(String contentType, String jsonObject, String url) {
		if (contentType.equalsIgnoreCase("JSON")) {
			response = requestSpec.contentType(contentType).body(jsonObject).when().put(url);
		}
		return response;
	}

	/*
	 * * Method for Delete Request
	 */
	public Response delete_request(String url) {
		response = requestSpec.when().delete(url);
		return response;
	}
}
