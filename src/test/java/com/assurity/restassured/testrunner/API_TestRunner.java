package com.assurity.restassured.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/features",

		glue = { "com.assurity.restassured.stepdefinitions" }, tags = { "@acceptance" }, plugin = {
				"junit:target/cucumber-reports/Cucumber.xml",// plugins can add  for testng
				"json:target/cucumber-reports/Cucumber.json",
				"com.cucumber.listener.ExtentCucumberFormatter:Reports/GetAPI_ResponseAcceptedCriteria.html" })

public class API_TestRunner {

}
