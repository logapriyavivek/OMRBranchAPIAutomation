package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.reports.Reporting;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
/**
 * 
 * @author LOGAPRIYA
 * @Description Used to Generate snippets and run the class
 * @CreationDate 24/06/2022
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(snippets = SnippetType.CAMELCASE, strict = true, dryRun = false, plugin = { "pretty",
		"json:target/api.json" }, monochrome = true, features = "src/test/resources", glue = "com.stepdefinition")
public class TestRunnerClass {
	@AfterClass
	public static void afterClass() {
		Reporting.generateJVMReport(System.getProperty("user.dir") + "\\target\\api.json");
	}

}
