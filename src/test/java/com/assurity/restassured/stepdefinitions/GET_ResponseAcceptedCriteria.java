package com.assurity.restassured.stepdefinitions;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.JSONArray;
import org.json.JSONObject;
import com.assurity.restassured.apiresponse.RestApiService;
import com.assurity.restasured.datautil.ConfigFileReader;
import com.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GET_ResponseAcceptedCriteria extends RestApiService {
	private Logger logger;
	ConfigFileReader config = new ConfigFileReader();

	@Before
	public void configloader(Scenario scenario) throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		config.loadPropertyFile("TestData.properties");
		logger = Logger.getLogger(GET_ResponseAcceptedCriteria.class);
	}

	@When("^User submit the GET request as per the data in  Json/property file  \"([^\"]*)\"$")
	public void user_submit_the_GET_request_as_per_the_data_in_Json_property_file(String name) throws Throwable {
		response = get_request(config.getProperty("HOSTPATH"));
		String name_ = response.jsonPath().get("Name");
		if (name.equals(name_)) {
			logger.info(name_);
		}
	}

	@When("^User should validate success status code  \"([^\"]*)\"$")
	public void user_should_validate_success_status_code(String statusCode){
		response = get_request(config.getProperty("HOSTPATH"));
		logger.info("Acceptance Criteria API Get Response is " + response.asString());
		if (response.statusCode() == 200) {
			logger.info("Get response code for Acceptance Criteria API : " + response.getStatusCode());
		}
	}

	@When("^User should validate response for boolean value \"([^\"]*)\"$")
	public void user_should_validate_response_for_boolean_value(String canRelist) {
		String canRelist_ = response.jsonPath().get("CanRelist").toString();
		if (canRelist.equals(canRelist_)) {
			logger.info(canRelist_);
		}
	}

	@Then("^User should validate response body list values for  \"([^\"]*)\" ,\"([^\"]*)\"$")
	public void user_should_validate_response_body_list_values_for(String promoName, String description){
		JSONObject json = new JSONObject(response.asString());
		JSONArray prom = json.getJSONArray("Promotions");
		for (int k = 0; k < prom.length(); k++) {
			String name = prom.getJSONObject(k).getString("Name");
			if (name.equals(promoName)) {
				String description_ = prom.getJSONObject(k).getString("Description");
				if (description_.contains(description)) {
					logger.info(name);
					Reporter.addStepLog("Promotions : Name:" + name + "description_" + description_);
				}
			}
		}
	}
}
